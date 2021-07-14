package com.example.imcmachine

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.constraint_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_main)
        setListeners()

    }

    private fun setListeners(){
        txtAltura?.doAfterTextChanged { text ->
        }

        txtPeso?.doOnTextChanged { text, _, _, _ ->
           // txtTitle?.text = text
        }

        btnCalcular.setOnClickListener {
            calcularIMC(txtPeso.text.toString(), txtAltura.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC(peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso!=null && altura!=null){
            val imc = peso / (altura * altura)
            var classificacao:String=""

            when {
                imc in 1.0 .. 18.5 -> {
                    classificacao ="🚨 MAGREZA"
                    txtTitle1.text = "$classificacao\n" +
                            "Atenção, seu nivel de IMC esta muito baixo"
                    txtTitle.text = "Seu IMC é $imc%2f".format((imc))
                }
                imc in 18.6 .. 24.9 -> {
                    classificacao ="👍 NORMAL"
                    txtTitle1.text =
                        "$classificacao\n😀 Parabens você esta no seu nivel ideal de IMC"
                    txtTitle.text = "Seu IMC é de $imc%2f".format((imc))
                }
                imc in 25.0 .. 29.9 -> {
                    classificacao ="⚠ SOBREPESO NIVEL 1"
                    txtTitle1.text = "$classificacao\nAtenção, seu nivel de IMC esta levemente elevado"
                    txtTitle.text = "Seu IMC é de $imc%2f".format((imc))
                }
                imc in 30.0 .. 39.9 -> {
                    classificacao="⚠ OBESIDADE NIVEL 2"
                    txtTitle1.text = "$classificacao\n" +
                            "Atenção, seu nivel de IMC esta acima do ideal"
                    txtTitle.text = "Seu IMC é de $imc%2f".format((imc))
                }
                imc > 40.0 -> {
                    classificacao="🚨 OBESIDADE GRAVE NIVEL 3"
                    txtTitle1.text = "$classificacao\nMenos disso \uD83C\uDF54 \uD83C\uDF55 e mais disso \uD83D\uDEB4\u200D♂️\uD83C\uDFCB️\u200D♀"
                    txtTitle.text = "Seu IMC é de $imc%2f".format((imc))
                }
            }
        }
    }
}
/*VEJA A INTERPRETAÇÃO DO IMC
IMC	CLASSIFICAÇÃO	OBESIDADE (GRAU)
MENOR QUE 18,5	MAGREZA	0
ENTRE 18,5 E 24,9	NORMAL	0
ENTRE 25,0 E 29,9	SOBREPESO	I
ENTRE 30,0 E 39,9	OBESIDADE	II
MAIOR QUE 40,0	OBESIDADE GRAVE	III

//Tipos de Layout de tela mais utilizados (Linear; Relative; Constraint)

//TextWatchers - Mudança dinamica de informação de texto conforme digitação do usuario
//Metodos de mudança com base no eventClick (beforeTextChanged; onTextChanged, e outros)

*/