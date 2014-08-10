package com.zhanglian2010.ui;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ShareActionProvider;

public class DataToOtherAppActivity extends Activity {

	static final int PICK_CONTACT_REQUEST = 1;  // The request code
	
	private Button button;
	
	private ShareActionProvider mShareActionProvider;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_to_another_app);
		
		button = (Button) findViewById(R.id.showMapId);
		button.setOnClickListener(new ShowMapButtonListener());
		
	}
	
	class ShowMapButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			
//			showMap();
			
			pickContact();
			
//			share2SocialNetwork();
		}
		
	} 
	
	private void showMap(){
		// Build the intent
		Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");

		Uri webpage = Uri.parse("http://www.baidu.com");
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, webpage);


		// Verify it resolves
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
		boolean isIntentSafe = activities.size() > 0;


		// Start an activity if it's safe
		if (isIntentSafe) {
			System.out.println("got app...");
			String title = getResources().getString(R.string.hello_world);
			// Create and start the chooser
			Intent chooser = Intent.createChooser(mapIntent, title);
			startActivity(chooser);
		} else {
			System.out.println("no app...");
		}
	}
	
	private void pickContact() {
	    Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
	    pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
	    startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
	}
	
	private void share2SocialNetwork(){
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		sendIntent.setType("text/plain");
		startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.hello_world)));
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request it is that we're responding to
	    if (requestCode == PICK_CONTACT_REQUEST) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	            // Get the URI that points to the selected contact
	            Uri contactUri = data.getData();
	            // We only need the NUMBER column, because there will be only one row in the result
	            String[] projection = {Phone.NUMBER};

	            // Perform the query on the contact to get the NUMBER column
	            // We don't need a selection or sort order (there's only one result for the given URI)
	            // CAUTION: The query() method should be called from a separate thread to avoid blocking
	            // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
	            // Consider using CursorLoader to perform the query.
	            Cursor cursor = getContentResolver()
	                    .query(contactUri, projection, null, null, null);
	            cursor.moveToFirst();

	            // Retrieve the phone number from the NUMBER column
	            int column = cursor.getColumnIndex(Phone.NUMBER);
	            String number = cursor.getString(column);
	            
	            System.out.println(number);

	            // Do something with the phone number...
	        }
	    }
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.to_another_app, menu);
		
		 // Locate MenuItem with ShareActionProvider
	    MenuItem item = menu.findItem(R.id.menu_item_share);

	    // Fetch and store ShareActionProvider
	    mShareActionProvider = (ShareActionProvider) item.getActionProvider();
	    
	    //一旦获取到了mShareActionProvider后，在适当的时候创建intent并设置内容（文本或流数据），将其set给mShareActionProvider即可
	    //之后ActionBar中的按钮被触发后，会自动将内容带到对应的分享app中
	    Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		sendIntent.setType("text/plain");
		
		setShareIntent(sendIntent);
	    
		return true;
	}
	
	// Call to update the share intent
	private void setShareIntent(Intent shareIntent) {
	    if (mShareActionProvider != null) {
	        mShareActionProvider.setShareIntent(shareIntent);
	    }
	}

}
