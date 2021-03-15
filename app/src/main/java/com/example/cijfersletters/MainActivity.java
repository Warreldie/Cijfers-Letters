package com.example.cijfersletters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
//DONE 1: Pas je app aan, zodat je twee fragments hebt. Eéntje voor "cijfers" en eentje voor "letters".
//TODO 2: "Letters" bevat twee knoppen ("klinker" en "medeklinker") en een TextView (die de gekozen letters toont)
//TODO 3: "Cijfers" bevat twee knoppen ("groot" en "klein") en twee TextViews (ééntje die de gekozen cijfers toont en ééntje voor het 'doelgetal' (die doet voorlopig nog niks))
//TODO 4: De layout van je Activity bevat deze twee fragments en nog één of twee knoppen (mag je kiezen), waarmee je tussen de twee fragments kan wisselen.
//TODO 5: Je past de app aan zodat de knoppen volgende functies hebben:
//TODO 6: klinker: de app genereert een klinker
//TODO 7: medeklinker: de app genereert een medeklinker
//TODO 8: klein: de app genereert een willekeurig getal tussen 1 en 10 (niet inclusief 10)
//TODO 9: groot: de app genereert een willekeurig getal uit volgende selectie: 10, 25, 50 en 100
//TODO 10: Je past de app aan zodat je de TextVeld niet telkens overschrijft, maar dat je een lijstje genereert vb: "A S T D" of "10 3 25 6 2"
//TODO 11: Als je wisselt tussen de fragments, wordt het TextView terug leeggemaakt.
//TODO 12: De "state" van het spel zit in je ViewModel.
/*
* Probeer zo weinig mogelijk logica in je Fragments of in je Activity te steken
* Het ViewModel heeft functies die zinvolle namen (en functionaliteit) hebben vanuit het oogpunt van de Fragments en Activity (vb: "generateVowel")
*/
//TODO 13: Gebruik het "observer"-patroon om te zorgen dat de verschillende TextViews automatisch updaten wanneer er iets verandert in het ViewModel.

    TextView tvLetter;
    LetterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(LetterViewModel.class);

        tvLetter = findViewById(R.id.tv_letter);

        viewModel.getLetter().observe(this, character ->
                tvLetter.setText(character.toString()));

        viewModel.getNumber().observe(this, number ->
                tvLetter.setText(number.toString()));
    }
    public void pickVowel(View v){
        viewModel.pickVowel();
    }
    public void pickConsonant(View v){
        viewModel.pickConsonant();
    }
    public void pickNumber(View v){
        viewModel.generateNumber();
    }
}