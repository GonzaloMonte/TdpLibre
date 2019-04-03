using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public  class juego  : MonoBehaviour
{
    public Text ganador;
    public Text puntacion;

    public Button irMenu;
    public Button revancha;


    static protected int puntaje1;
    static protected int puntaje2;

    static protected int puntajeMaximo = 5;

    void Start() {  puntacion.text = "0 - 0";
        puntaje1 = 0;
        puntaje2 = 0;
    }

    void Update()
    {
        puntacion.text = puntaje1.ToString () + " - "+  puntaje2.ToString();
        if (puntaje1 == puntajeMaximo)
        {
            ganador.text = "Gano player 1";
            activar();
           
        }
        if (puntaje2 == puntajeMaximo)
        {
            ganador.text = "Gano player 2";
            activar();
        }
    }
    static public void sumarPuntaje1()
    {
        puntaje1++;
    }
    static public void sumarPuntaje2()
    {
        puntaje2++;
    }
    static public int getPuntaje1()
    {
        return puntaje1;
    }
    static public int getPuntaje2()
    {
        return puntaje2;
    }
    static public int getMaximoPuntaje()
    {
        return puntajeMaximo;
    }
    protected void activar()
    {
        ganador.gameObject.SetActive(true);
        irMenu.gameObject.SetActive(true);
        revancha.gameObject.SetActive(true);
    }
}
