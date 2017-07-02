package com.android.tutorial.custom_view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomView extends ConstraintLayout {
    public CustomView(Context context) {
        super(context);
        init(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.custom_view, this);
        Button add = findViewById(R.id.Add);
        Button subtract = findViewById(R.id.Subtract);
        final TextView textView = findViewById(R.id.textView);

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer val = Integer.parseInt(textView.getText().toString());
                val = val+1;
                textView.setText(val.toString());
            }
        });

        subtract.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer val = Integer.parseInt(textView.getText().toString());
                val = val-1;
                textView.setText(val.toString());
            }
        });
    }
}
