package com.zhanglian2010.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewCutActivity extends Activity implements OnClickListener {

	private static final int SELECT_CODE = 1;
	private static final int CUT_CODE = 1;

	private Button imageSelect;
	private Button imageCut;

	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_view_cut);

		imageSelect = (Button) findViewById(R.id.imageSelect);
		imageCut = (Button) findViewById(R.id.imageCut);
		image = (ImageView) findViewById(R.id.imageShow);

		imageSelect.setOnClickListener(this);
		imageCut.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.image_view_cut, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(resultCode == RESULT_OK){
			if(requestCode == SELECT_CODE){
				//处理图片按照手机屏幕大小显示
				Uri uri = data.getData();
				int dw = getWindowManager().getDefaultDisplay().getWidth();
				int dh = getWindowManager().getDefaultDisplay().getHeight();

				try {
					BitmapFactory.Options option = new BitmapFactory.Options();
					//true表示允许查询图片不是按照像素分配给内存
					option.inJustDecodeBounds = true;
					Bitmap bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, option);

					//让图片匹配手机屏幕
					int hRatio = (int) Math.ceil( option.outHeight/(float)dh );
					//大于1表示图片高度大于手机屏幕高度
					int wRatio = (int) Math.ceil( option.outWidth/(float)dw );
					if(hRatio>1 || wRatio>1){
						option.inSampleSize = Math.max(hRatio, wRatio);
					}
					//
					option.inJustDecodeBounds = false;
					//再次使用选项参数适配图片的大小
					bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, option);
					image.setImageBitmap(bmp);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}else if(requestCode == CUT_CODE){
				Bitmap bitmap = data.getParcelableExtra("data");
				image.setImageBitmap(bitmap);
			}
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.imageSelect:
				//选择图片
				Intent intent = new Intent(Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	
				startActivityForResult(intent, SELECT_CODE);
				break;
			case R.id.imageCut:
				//显示裁剪图片
				System.out.println("cut...");
				Intent intent2 = getImageClipIntent();
				startActivityForResult(intent2, CUT_CODE);
				break;
		default:
			break;
		}
	}

	/**
	 * FIXME 出不来裁剪框
	 * @return
	 */
	private Intent getImageClipIntent() {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		//实现对图片的裁剪，必须要设置图片的属性
		intent.setType("image/*");//获取任意图片类型
		intent.putExtra("crop", "true");//滑动选中图片区域

		intent.putExtra("aspectX", 1);//表示剪切框的比例1:1效果
		intent.putExtra("aspectY", 1);//

		intent.putExtra("outputX", 60);//指定输出图片的大小
		intent.putExtra("outputY", 60);

		intent.putExtra("return-data", true);
		return intent;
	}

}
