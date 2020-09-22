//pacotes
package com.example.gastodeviagem

//bibliotecas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), //classe principal


        View.OnClickListener {            //implantando a interface de onclick atravéz do OnClickListener

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Capturando o botão da activymain

        buttonCalculate.setOnClickListener(this) //Botão de Calcúlo
        buttonLimpar.setOnClickListener(this)    //Botão de Limpar
    }

        //função dos botões implementados pós implatação da interface

        override fun onClick(view: View) {

        //declaração dos botões

        val id = view.id      //botão de calcular
        val id2 = view.id     //botão de limpar

        if (id == R.id.buttonCalculate) {           //Se o botão calcular for acionado
            calculate()                             // a função calcular será executada
        } else if (id2 == R.id.buttonLimpar) {      //senão se o botão limpar for acionado
            limpar()                                // a função limpar será executada
        }
    }

    //Função de calculo para o  botão calcular

    private fun calculate() {
        if (validationOk()) {  //se o retorno da função validationOk for true

            try {       // aqui foi criado um tratamento de erro para que o aplicativo continue sendo executado, capturando os códigos que podem podem gerar possiveis erros
                        // caso o usuário digite algum valor inválido

                val distance = editdistancie.text.toString().toFloat()
                val price = editprice.text.toString().toFloat()
                val autonomy = editautonomy.text.toString().toFloat()
                val totalvalue = (distance * price) / autonomy

                //linha para exibir o resultado ja com a formatação para aparecer 2 casas após a virgula usando a "%.2f ligada a função format

                textTotalvalue.text = "R$ ${"%.2f".format(totalvalue)}"


            } catch (zero: NumberFormatException) {       //caso o usuário entre com um valor não compátivel com o tipo da variável aceita
                Toast.makeText(
                    this,
                    getString(R.string.Valoes_Validos), //será executado na tela um toast com a notificação "Por favor, informe valores válidos"
                    Toast.LENGTH_LONG
                )

            }


        } else { //se não
            Toast.makeText(this, getString(R.string.Preencha_Todos_Campos), Toast.LENGTH_LONG).show()  //será executado um toast com a notificação "preencha todos os campos"
        }
    }

    // criando função inLine de validação, nos retornando um valor boolean: verdadeiro ou falso
    // caso seja digitado nos campos um valor diferente de nulo, a função me retornará true

    private fun validationOk(): Boolean =(editdistancie.text.toString() != ""
                                          && editprice.text.toString() != ""
                                          && editautonomy.text.toString() != ""
                                          && editautonomy.text.toString() != ""
                                          )

    private fun limpar() {
        // criando uma função para o botão limpar, e atribuindo valores nulos aos campos, assim que esse botão for acionado

        editdistancie.text = null
        editprice.text = null
        editautonomy.text = null
        textTotalvalue.text = "R$ 0"
        Toast.makeText(this, getString(R.string.apagardados), Toast.LENGTH_LONG).show() //foi criado um toast com a notificação "Dados apagados"

    }
}





