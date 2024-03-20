package com.my.calculator

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.my.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text
import java.util.logging.Handler


class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acId.setOnClickListener{
            binding.inputTx.text=""
            binding.outputTx.text=""
            playsound()

        }
        binding.zeroId.setOnClickListener{
            binding.inputTx.append("0")

        }
        binding.oneId.setOnClickListener{
            binding.inputTx.append("1")
       
        }
        binding.twoId.setOnClickListener{
            binding.inputTx.append("2")
       
        }
        binding.threeId.setOnClickListener{
            binding.inputTx.append("3")
      
        }
        binding.fourId.setOnClickListener{
            binding.inputTx.append("4")
            
        }
        binding.fiveId.setOnClickListener{
            binding.inputTx.append("5")
         
        }
        binding.sixId.setOnClickListener{
            binding.inputTx.append("6")
         
        }
        binding.sevenId.setOnClickListener{
            binding.inputTx.append("7")
         
        }
        binding.eightId.setOnClickListener{
            binding.inputTx.append("8")
         
        }
        binding.nineId.setOnClickListener{
            binding.inputTx.append("9")
         
        }

        binding.dotId.setOnClickListener {
            binding.inputTx.append(".")
         
        }
         binding.plusId.setOnClickListener {
            binding.inputTx.append("+")
          
        }
         binding.minsId.setOnClickListener {
            binding.inputTx.append(" - ")
          
        }
         binding.multiplyId.setOnClickListener {
            binding.inputTx.append(" * ")
          
        }
         binding.openId.setOnClickListener {
            binding.inputTx.append(" ( ")
          
        }
         binding.closeId.setOnClickListener {
            binding.inputTx.append(" ) ")
          
        }
         binding.divId.setOnClickListener {
            binding.inputTx.append(" / ")
          
        }

        // "The heart of calculator", ( = )

        binding.equalId.setOnClickListener {
            val inputText = binding.inputTx.text.toString().trim() // Trim any leading or trailing spaces
            if (inputText.isNotEmpty()) {
                val expression = ExpressionBuilder(inputText).build()
                if (expression != null) {
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()) {
                        binding.outputTx.text = longResult.toString()
                    } else {
                        binding.outputTx.text = result.toString()
                    }
                } else {
                    Toast.makeText(this, "Invalid expression", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter something...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun playsound(){

        var media= MediaPlayer.create(this,R.raw.sound)
        media.start()

    }

}
