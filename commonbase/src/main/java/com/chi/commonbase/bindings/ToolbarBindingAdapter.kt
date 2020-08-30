package com.chi.commonbase.bindings

import androidx.appcompat.widget.Toolbar


// https://github.com/worldturtlemedia/whalesay/blob/c814ffd7a86e8fad1b9af2362d26c5fe6cc9aea4/core/core-view/src/main/java/com/worldturtlemedia/whalesay/core/view/bindingadapters/ToolbarBindingAdapter.kt
/*@BindingAdapter("animateVisibility")
fun Toolbar.animateVisibility(visible: Boolean) {
    val needsToAnimate = (visible && isHidden) || (!visible && !isHidden)
    if (!needsToAnimate) return

    val animateTo = if (visible && isHidden) 0 else -heightDefault
    animateY(animateTo.toFloat(), duration = Constants.NAV_HOST_ANIMATION_DURATION)
}*/

private val Toolbar.isHidden: Boolean
    get() = y < 0f

/*
private val Toolbar.heightDefault
    get() = if (height == 0) context.dimen(R.dimen.actionBarSize).toInt() else height*/
