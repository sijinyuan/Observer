package com.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView longitude;//设置显示经度文本框
    private TextView latitude;//设置显示纬度文本框
    private TextView isPicked;//设置是否捕获到经纬度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location();//通过调用此成员方法,设置经纬度

    }
    private void location() {
        new CoordinateHelper(this, longitude, latitude);
        /**
         * Set a special listener to be called when an action is performed on the text view.
         * This will be called when the enter key is pressed, or when an action supplied to the IME is selected by the user.
         * Setting this means that the normal hard key event will not insert a newline into the text view, even if it is multi-line;
         * holding down the ALT modifier will, however, allow the user to insert a newline character.
         *
         * */
        latitude.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
                // TODO Auto-generated method stub
                return false;
            }

        });
        /**
         * Adds a TextWatcher to the list of those whose methods are called
         * whenever this TextView's text changes
         */
        latitude.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub

            }
            /**
             * This method is called to notify you that, within s,
             * the count characters beginning at start have just replaced old text that had length before.
             * It is an error to attempt to make changes to s from this callback.
             */

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
                if ("0.0".equals(longitude.getText().toString())
                        || "".equals(longitude.getText().toString())) {//如果获取不到纬度或者得到经度为0，则显示是否获得经纬度为否
                    isPicked.setText("否");
                } else {
                    isPicked.setText("是");
                }
            }

        });
        longitude.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
                // TODO Auto-generated method stub
                return false;
            }

        });
        longitude.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
                if ("0.0".equals(longitude.getText().toString())
                        || "".equals(longitude.getText().toString())) {////如果获取不到经度或者得到经度为0，则显示是否获得经纬度为否
                    isPicked.setText("否");
                } else {
                    isPicked.setText("是");
                }
            }

        });
    }


}
