package com.badut.kinvaders

interface IMoveComponent {
    fun update(fps: Long, gameObject: GameObject) {}
}
