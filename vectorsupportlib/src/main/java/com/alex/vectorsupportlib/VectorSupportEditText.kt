package com.alex.vectorsupportlib

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatEditText

/**
 * Created by xuanhong on 9/4/18. HappyCoding!
 */
open class VectorSupportEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = androidx.appcompat.R.attr.editTextStyle) : AppCompatEditText(context, attrs, defStyleAttr) {

    init {
        initAttrs(context, attrs)
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.VectorSupportEditText)

            var dStart: Drawable? = null
            val drawableStartSquareSize: Int
            var dEnd: Drawable? = null
            val drawableEndSquareSize: Int
            var dBottom: Drawable? = null
            val drawableBottomSquareSize: Int
            var dTop: Drawable? = null
            val drawableTopSquareSize: Int
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                dStart = attributeArray.getDrawable(R.styleable.VectorSupportEditText_supportDrawableStart)
                dEnd = attributeArray.getDrawable(R.styleable.VectorSupportEditText_supportDrawableEnd)
                dBottom = attributeArray.getDrawable(R.styleable.VectorSupportEditText_supportDrawableBottom)
                dTop = attributeArray.getDrawable(R.styleable.VectorSupportEditText_supportDrawableTop)
            } else {
                val drawableStartId = attributeArray.getResourceId(R.styleable.VectorSupportEditText_supportDrawableStart, 0)
                val drawableEndId = attributeArray.getResourceId(R.styleable.VectorSupportEditText_supportDrawableEnd, 0)
                val drawableBottomId = attributeArray.getResourceId(R.styleable.VectorSupportEditText_supportDrawableBottom, 0)
                val drawableTopId = attributeArray.getResourceId(R.styleable.VectorSupportEditText_supportDrawableTop, 0)

                if (drawableStartId != 0) {
                    dStart = AppCompatResources.getDrawable(context, drawableStartId)
                }
                if (drawableEndId != 0) {
                    dEnd = AppCompatResources.getDrawable(context, drawableEndId)
                }
                if (drawableBottomId != 0) {
                    dBottom = AppCompatResources.getDrawable(context, drawableBottomId)
                }
                if (drawableTopId != 0) {
                    dTop = AppCompatResources.getDrawable(context, drawableTopId)
                }
            }

            drawableStartSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportEditText_supportDrawableStartSquareSize, -1)
            drawableEndSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportEditText_supportDrawableEndSquareSize, -1)
            drawableBottomSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportEditText_supportDrawableBottomSquareSize, -1)
            drawableTopSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportEditText_supportDrawableTopSquareSize, -1)

            if (drawableStartSquareSize != -1) {
                dStart?.setBounds(0, 0, drawableStartSquareSize, drawableStartSquareSize)
            }
            if (drawableEndSquareSize != -1) {
                dStart?.setBounds(0, 0, drawableEndSquareSize, drawableEndSquareSize)
            }
            if (drawableBottomSquareSize != -1) {
                dStart?.setBounds(0, 0, drawableBottomSquareSize, drawableBottomSquareSize)
            }
            if (drawableTopSquareSize != -1) {
                dStart?.setBounds(0, 0, drawableTopSquareSize, drawableTopSquareSize)
            }

            val hasCustomSize = drawableStartSquareSize != -1
                    || drawableEndSquareSize != -1
                    || drawableBottomSquareSize != -1
                    || drawableTopSquareSize != -1

            if (hasCustomSize)
                setCompoundDrawablesRelative(dStart, dTop, dEnd, dBottom)
            else
                setCompoundDrawablesRelativeWithIntrinsicBounds(dStart, dTop, dEnd, dBottom)
            attributeArray.recycle()
        }
    }

    fun drawableCompat(@DrawableRes startResId: Int = 0, @DrawableRes topResId: Int = 0, @DrawableRes endResId: Int = 0, @DrawableRes bottomResId: Int = 0) {
        var dStart: Drawable? = null
        var dEnd: Drawable? = null
        var dBottom: Drawable? = null
        var dTop: Drawable? = null

        if (startResId != 0)
            dStart = AppCompatResources.getDrawable(context, startResId)
        if (endResId != 0)
            dEnd = AppCompatResources.getDrawable(context, endResId)
        if (bottomResId != 0)
            dBottom = AppCompatResources.getDrawable(context, bottomResId)
        if (topResId != 0)
            dTop = AppCompatResources.getDrawable(context, topResId)

        setCompoundDrawablesRelativeWithIntrinsicBounds(dStart, dTop, dEnd, dBottom)
    }
}