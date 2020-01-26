package com.badut.kinvaders

import android.graphics.Point
import kotlin.random.Random

class EnemyAI(private val size: Point, private val allies: ArrayList<GameObject>, private val player: GameObject) : IEnemyController {
    override fun update(wave: Int) {
        var reverse = false
        for(ally in allies) {
            if(ally.moving == GameObject.right && ally.position.right >= size.x ||
                ally.moving == GameObject.left && ally.position.left <= 0) {
                reverse = true
                break
            }
        }

        if(Random.nextInt(0, 1000) > 990) {
            val randomShooter = Random.nextInt(0, allies.size)
            allies[randomShooter].action2 = true
        }

        if(reverse) {
            for(ally in allies) {
                if(ally.moving == GameObject.left)
                    ally.moving = GameObject.right
                else if(ally.moving == GameObject.right)
                    ally.moving = GameObject.left

                val height = ally.position.height()
                ally.position.top += height
                ally.position.bottom += height
            }
        }
    }
}