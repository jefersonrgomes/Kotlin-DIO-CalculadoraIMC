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
            txtTitle.text = "Seu IMC é de $imc%f".format((imc))
        }


        /*VEJA A INTERPRETAÇÃO DO IMC
IMC	CLASSIFICAÇÃO	OBESIDADE (GRAU)
MENOR QUE 18,5	MAGREZA	0
ENTRE 18,5 E 24,9	NORMAL	0
ENTRE 25,0 E 29,9	SOBREPESO	I
ENTRE 30,0 E 39,9	OBESIDADE	II
MAIOR QUE 40,0	OBESIDADE GRAVE	III

        RESULTADO:
Cara expressiva Parabéns, seu IMC é 23.9 kg/m2 e você está dentro do peso adequado!
De acordo com a sua altura e idade, o seu peso pode variar entre 50 kg e 68 kg, por isso continue tendo cuidado com a alimentação e praticando atividade física regularmente para manter o peso e prevenir doenças.

IMC	PESO
Magreza	< 18.5	< 50.4 Kg
Normal	18.5 a 24.9	50.4 a 67.8 Kg
Sobrepeso	24.9 a 30	67.8 a 81.7 Kg
Obesidade	> 30	> 81.7 Kg

        */


        /*O que é IMC?
IMC significa Índice de Massa Corporal e é um parâmetro utilizado para saber se o peso está de acordo com a altura, o que pode interferir diretamente na saúde e qualidade de vida da pessoa. Assim, a partir do resultado do IMC é possível saber também se a pessoa está dentro do peso ideal e também identificar sobrepeso, obesidade ou desnutrição em crianças, adolescentes, adultos ou idosos.

Dessa forma, com o cálculo do IMC, é possível fazer algumas mudanças na rotina diária, como mudar a dieta, melhorar os hábitos alimentares e praticar atividade física de forma regular, por exemplo.

Como é calculado?
O IMC é a relação entre peso e altura e o cálculo é feito de acordo com a fórmula: IMC = peso/ (altura x altura), devendo o peso estar em kg e a altura em metro, e o resultado é dado em kg/m2. Depois de obter o resultado, é possível verificar em que faixa o IMC se encontra, podendo indicar:

Magreza, quando o resultado é menor que 18,5 kg/m2;
Normal, quando o resultado está entre 18,5 e 24,9 kg/m2;
Sobrepeso, quando o resultado está entre 24,9 e 30 kg/m2;
Obesidade, quando o resultado é maior que 30 kg/m2.
Assim, de acordo com o resultado do IMC é possível também saber se existe algum risco de desenvolver doenças. Isto porque quanto maior é o valor do IMC, maior é a quantidade de gordura acumulada no corpo e maior é o risco da pessoa ter doenças como pressão alta, diabetes e doenças cardíacas.*/

    }


}


//Tipos de Layout de tela mais utilizados (Linear; Relative; Constraint)

//TextWatchers - Mudança dinamica de informação de texto conforme digitação do usuario
//Metodos de mudança com base no eventClick (beforeTextChanged; onTextChanged, e outros)

