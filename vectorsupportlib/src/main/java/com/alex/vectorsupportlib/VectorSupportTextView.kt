package com.alex.vectorsupportlib

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Created by xuanhong on 9/4/18. HappyCoding!
 */
open class VectorSupportTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        initAttrs(context, attrs)
    }

    private var drawableStartSquareSize: Int = -1
    private var drawableEndSquareSize: Int = -1
    private var drawableBottomSquareSize: Int = -1
    private var drawableTopSquareSize: Int = -1
    private var drawableTintColor: Int = -1


    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.VectorSupportTextView)

            var dStart: Drawable? = null
            var dEnd: Drawable? = null
            var dBottom: Drawable? = null
            var dTop: Drawable? = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                dStart = attributeArray.getDrawable(R.styleable.VectorSupportTextView_drawableStartCompat)
                dEnd = attributeArray.getDrawable(R.styleable.VectorSupportTextView_drawableEndCompat)
                dBottom = attributeArray.getDrawable(R.styleable.VectorSupportTextView_drawableBottomCompat)
                dTop = attributeArray.getDrawable(R.styleable.VectorSupportTextView_drawableTopCompat)
            } else {
                val drawableStartId = attributeArray.getResourceId(R.styleable.VectorSupportTextView_drawableStartCompat, 0)
                val drawableEndId = attributeArray.getResourceId(R.styleable.VectorSupportTextView_drawableEndCompat, 0)
                val drawableBottomId = attributeArray.getResourceId(R.styleable.VectorSupportTextView_drawableBottomCompat, 0)
                val drawableTopId = attributeArray.getResourceId(R.styleable.VectorSupportTextView_drawableTopCompat, 0)

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

            drawableStartSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportTextView_drawableStartSquareSize, -1)
            drawableEndSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportTextView_drawableEndSquareSize, -1)
            drawableBottomSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportTextView_drawableBottomSquareSize, -1)
            drawableTopSquareSize = attributeArray.getDimensionPixelSize(R.styleable.VectorSupportTextView_drawableTopSquareSize, -1)

            if (drawableStartSquareSize != -1) {
                dStart?.setBounds(0, 0, drawableStartSquareSize, drawableStartSquareSize)
            }
            if (drawableEndSquareSize != -1) {
                dEnd?.setBounds(0, 0, drawableEndSquareSize, drawableEndSquareSize)
            }
            if (drawableBottomSquareSize != -1) {
                dBottom?.setBounds(0, 0, drawableBottomSquareSize, drawableBottomSquareSize)
            }
            if (drawableTopSquareSize != -1) {
                dTop?.setBounds(0, 0, drawableTopSquareSize, drawableTopSquareSize)
            }

            val hasCustomSize = drawableStartSquareSize != -1
                    || drawableEndSquareSize != -1
                    || drawableBottomSquareSize != -1
                    || drawableTopSquareSize != -1

            if (hasCustomSize)
                setCompoundDrawablesRelative(dStart, dTop, dEnd, dBottom)
            else
                setCompoundDrawablesRelativeWithIntrinsicBounds(dStart, dTop, dEnd, dBottom)

            drawableTintColor = attributeArray.getColor(R.styleable.VectorSupportTextView_drawableTintCompat, -1)
            if (drawableTintColor != -1)
                tintDrawable(drawableTintColor)


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

        if (drawableStartSquareSize != -1) {
            dStart?.setBounds(0, 0, drawableStartSquareSize, drawableStartSquareSize)
        }
        if (drawableEndSquareSize != -1) {
            dEnd?.setBounds(0, 0, drawableEndSquareSize, drawableEndSquareSize)
        }
        if (drawableBottomSquareSize != -1) {
            dBottom?.setBounds(0, 0, drawableBottomSquareSize, drawableBottomSquareSize)
        }
        if (drawableTopSquareSize != -1) {
            dTop?.setBounds(0, 0, drawableTopSquareSize, drawableTopSquareSize)
        }

        val hasCustomSize = drawableStartSquareSize != -1
                || drawableEndSquareSize != -1
                || drawableBottomSquareSize != -1
                || drawableTopSquareSize != -1

        if (hasCustomSize)
            setCompoundDrawablesRelative(dStart, dTop, dEnd, dBottom)
        else
            setCompoundDrawablesRelativeWithIntrinsicBounds(dStart, dTop, dEnd, dBottom)

        if (drawableTintColor != -1)
            tintDrawable(drawableTintColor)
    }

    fun tintDrawable(@ColorInt color: Int) {
        compoundDrawablesRelative.map {
            it?.let {
                DrawableCompat.setTint(it, color)
            }
        }

        compoundDrawables.map {
            it?.let {
                DrawableCompat.setTint(it, color)
            }
        }
    }
}