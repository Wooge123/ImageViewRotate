package com.example.imageviewrotate;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView tvAngle;
	private Button btnLeft, btnRight;
	private ImageView image;
	private int scaleAngle;
	private Bitmap sourceBmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvAngle = (TextView) findViewById(R.id.tvAngle);
		image = (ImageView) findViewById(R.id.image);
		btnLeft = (Button) findViewById(R.id.btnLeft);
		btnRight = (Button) findViewById(R.id.btnRight);
		btnLeft.setOnClickListener(this);
		btnRight.setOnClickListener(this);
		scaleAngle = 0;
		sourceBmp = BitmapFactory.decodeResource(getResources(), R.drawable.test);
		image.setImageBitmap(sourceBmp);
	}

	@Override
	public void onClick(View v) {
		int widthOrig = sourceBmp.getWidth();
		int heightOrig = sourceBmp.getHeight();
		if (v.getId() == R.id.btnLeft) {
			scaleAngle--;
			if (scaleAngle < -5)
				scaleAngle = -5;
		}
		if (v.getId() == R.id.btnRight) {
			scaleAngle++;
			if (scaleAngle > 5)
				scaleAngle = 5;
		}
		Matrix matrix = new Matrix();
		matrix.setRotate(5 * scaleAngle);
		Bitmap resizedBitmap = Bitmap.createBitmap(sourceBmp, 0, 0, widthOrig, heightOrig, matrix, true);
		image.setImageBitmap(resizedBitmap);
		tvAngle.setText("角度：" + 5 * scaleAngle);
	}

}
