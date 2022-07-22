package com.zr.align;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;

public class AlignTextView extends AppCompatTextView {
    public AlignTextView(@NonNull Context context) {
        super(context);
    }

    public AlignTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AlignTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!setTextFlag) {
            Log.i("=====","====2222222222=");
            AlignTextView.super.setText(computeTextLength(originText));
        } else {
            Log.i("=====","====3333333333=");
            setTextFlag = false;
        }
    }

    private CharSequence originText;
    private boolean setTextFlag;

    @Override
    public CharSequence getText() {
        if (TextUtils.isEmpty(originText)) {
            CharSequence text = super.getText();
            if (TextUtils.isEmpty(text)) {
                return "";
            }
            return text;
        }
        return originText;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setText(CharSequence text, BufferType type) {
        if (TextUtils.equals(text, originText)) {
            return;
        }
        if (!setTextFlag) {
            originText = text;
        }
        Log.i("=====","====1111111111=");
        super.setText(text, type);
        requestLayout();
    }


    private int flag = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;

    private CharSequence computeTextLength(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            return text;
        }
        Layout layout = getLayout();
        if (layout == null) {
            return text;
        }
        int lineCount = layout.getLineCount();
        if (lineCount == 1) {
            return text;
        }
        int measuredWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        TextPaint paint = getPaint();
        Rect rect;
        CharSequence charSequence;

        SpannableStringBuilder builder = new SpannableStringBuilder();
        ColorDrawable colorDrawable;
        /*最后一行不需要计算*/
        for (int i = 0; i < lineCount - 1; i++) {
            rect = new Rect();
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            charSequence = text.subSequence(lineStart, lineEnd);

            int textRectWidth = (int) paint.measureText(charSequence, 0, charSequence.length());

            int spaceWidth = measuredWidth - textRectWidth;

            /*如果当前行文字已经右对齐了，就不需要添加间隙了*/
            if (spaceWidth <= 1) {
                builder.append(charSequence);
                continue;
            }
            /*每行文本的间隔数量*/
            int lineLength = lineEnd - lineStart - 1;

            /*不计算每行第一个字，从每行第二个字开始加间距*/
            /*保证每个item间隙为整数*/
            int eachWidth = (int) (spaceWidth * 1d / lineLength + 0.9d);

            if (eachWidth <= 0) {
                eachWidth = 1;
            }

            int tempWidth = 0;
            CharSequence charText;

            for (int j = lineStart; j < lineEnd; j++) {
                int spanStart = builder.length();
                charText = text.subSequence(j, j + 1);
                builder.append(charText);
                int spanEnd = builder.length();

                /*如果是当前行的最后一个字，就不用加间距了*/
                if (j >= lineEnd - 1) {
                    continue;
                }

                /*如果剩余的宽度小于之前计算的,就不用继续加间距了*/
                int remainderWidth = (spaceWidth - tempWidth);
                /*如果目前的间距超过每行间距总和，也不需要继续加间距了*/
                if (remainderWidth <= 0 || tempWidth >= spaceWidth - 2) {
                    continue;
                }

                spanStart = builder.length();
                /*占位用于被替换成图片间距*/
                builder.append(".");
                spanEnd = builder.length();

                colorDrawable = new ColorDrawable(Color.TRANSPARENT);
                if (remainderWidth < eachWidth) {
                    colorDrawable.setBounds(0, 0, remainderWidth, 0);
                    builder.setSpan(new ImageSpan(colorDrawable), spanStart, spanEnd, flag);
                    continue;
                }
                colorDrawable.setBounds(0, 0, eachWidth, 0);
                builder.setSpan(new ImageSpan(colorDrawable), spanStart, spanEnd, flag);

                tempWidth += eachWidth;
            }
        }
        /*加上最后一行*/
        int lineStart = layout.getLineStart(lineCount - 1);
        int lineEnd = layout.getLineEnd(lineCount - 1);
        builder.append(text.subSequence(lineStart, lineEnd));
        setTextFlag = true;
        return builder;
    }
}