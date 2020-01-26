package com.badut.kinvaders

import android.graphics.Canvas

interface IGraphicsComponent {
    fun draw(canvas: Canvas, gameObject: GameObject) {}
}