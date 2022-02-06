package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * this activity is allow users to roll dice and see the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * roll the dice and update screen with roll result
     */
    private fun rollDice() {
        // create new dice object with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // update the screen with dice image result
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_2)
    }
}
/**
 * create class with dice logic
 */
class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}