package com.mobile.customprogress

import android.content.Context
import android.os.Build
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item


class ItemImageView(
    val viewId1: Int,
    val viewId2: Int? = null,
    val context: Context,
    val state: Int,
    val circleType: String = "L"
) :
    Item<GroupieViewHolder>() {

    override fun getLayout() = R.layout.item_imgae

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val imgCircle = viewHolder.itemView.findViewById<ImageView>(R.id.iv_circle)
        val imgRect = viewHolder.itemView.findViewById<ImageView>(R.id.iv_rect)
        val rlCircle = viewHolder.itemView.findViewById<RelativeLayout>(R.id.rl_circle)

        imgCircle.setImageResource(viewId1)
        if (state == 1) {
            imgCircle.setColorFilter(
                ContextCompat.getColor(context, R.color.white),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            imgRect.setColorFilter(
                ContextCompat.getColor(context, R.color.blue),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                rlCircle.background.colorFilter =
                    BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                        ContextCompat.getColor(
                            context,
                            R.color.blue
                        ), BlendModeCompat.SRC_ATOP
                    )
            }
        }
        if (circleType == "S") {
            rlCircle.background = ContextCompat.getDrawable(context, R.drawable.bg_circle_small)
        }
        if (state == 2) {

            imgCircle.setColorFilter(
                ContextCompat.getColor(context, R.color.white),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            imgRect.setColorFilter(
                ContextCompat.getColor(context, R.color.green),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                rlCircle.background.colorFilter =
                    BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                        ContextCompat.getColor(
                            context,
                            R.color.green
                        ), BlendModeCompat.SRC_ATOP
                    )
            }
        }
        if (viewId2 != null) {
            imgRect.setImageResource(viewId2)
        }
    }
}