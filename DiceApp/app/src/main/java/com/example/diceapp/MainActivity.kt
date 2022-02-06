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
        /**
         * do a dice roll when the app is start
         */
        rollDice()
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
        val drawableResource = when (diceRoll){
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        diceImage.setImageResource(drawableResource)
        // set description of dice image
        diceImage.contentDescription = diceRoll.toString()
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