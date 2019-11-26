package com.example.spannablestring

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.text.style.ClickableSpan




class MainActivity : AppCompatActivity() {

    var originalText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        originalText = spannableTextView.text as String

        btnSetForegroundColor.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val foregroundColorSpan = ForegroundColorSpan(Color.RED)
            spannableStr.setSpan(foregroundColorSpan, 15, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        btnSetBackgroundColor.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val backgroundColorSpan = BackgroundColorSpan(Color.GREEN)
            spannableStr.setSpan(backgroundColorSpan, 15, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Add under line to specified text.
        btnSetUnderLine.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val underlineSpan = UnderlineSpan()
            spannableStr.setSpan(underlineSpan, 15, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Add strike through line to specified text.
        btnSetStrikeThrough.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val strikethroughSpan = StrikethroughSpan()
            spannableStr.setSpan(strikethroughSpan, 15, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Change specified text font size.
        btnSetRelativeSize.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val relativeSizeSpan1 = RelativeSizeSpan(1.2f)
            val relativeSizeSpan2 = RelativeSizeSpan(1.8f)
            val relativeSizeSpan3 = RelativeSizeSpan(2.6f)
            spannableStr.setSpan(relativeSizeSpan1, 15, 19, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableStr.setSpan(relativeSizeSpan2, 19, 24, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableStr.setSpan(relativeSizeSpan3, 24, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Change specified text style.
        btnSetStyle.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val styleSpanBold = StyleSpan(Typeface.BOLD)
            val styleSpanItalic = StyleSpan(Typeface.ITALIC)
            spannableStr.setSpan(styleSpanBold, 15, 19, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableStr.setSpan(styleSpanItalic, 19, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Change specified text superscript.
        btnSetSuperscript.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val superscriptSpan = SuperscriptSpan()
            spannableStr.setSpan(superscriptSpan, 15, 16, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Change specified text subscript.
        btnSetSubScript.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val subscriptSpan = SubscriptSpan()
            spannableStr.setSpan(subscriptSpan, 15, 16, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Add images in text.
        btnSetSubImage.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val drawable = resources.getDrawable(R.drawable.ic_launcher_background)
            drawable.setBounds(0, 0, 100, 100)
            val imageSpan = ImageSpan(drawable)
            spannableStr.setSpan(imageSpan, 15, 19, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
        // Add URL in text.
        btnSetUrl.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val urlSpan = URLSpan("http://www.yahoo.com")
            spannableStr.setSpan(urlSpan, 15, 19, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.movementMethod = LinkMovementMethod.getInstance()
            spannableTextView.text = spannableStr
        }


        // Add Clickable in text.
        btnSetClickable.setOnClickListener {
            val spannableStr = SpannableString(originalText)
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(view: View) {
                    val dlg = AlertDialog.Builder(this@MainActivity).create()
                    dlg.setMessage("You click the text.")
                    dlg.show()
                }
            }
            spannableStr.setSpan(clickableSpan, 15, 30, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            spannableTextView.text = spannableStr
        }
    }
}