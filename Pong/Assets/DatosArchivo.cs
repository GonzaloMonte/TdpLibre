using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.IO;

public class DatosArchivo 
{
    int pongMax;
    string pathPong;

    public DatosArchivo()
    {
        pongMax = 5;


        //Path de los archivos
        pathPong = Application.dataPath + "/DatosPong.txt";


        //Crear los archivos, si es que no existen
        if (!File.Exists(pathPong))
            File.WriteAllText(pathPong, pongMax + " - es la mejor puntuacion arcade");
        else
            recuperar_PongMax();
    }

    private void recuperar_PongMax()
    {
        string Texto = File.ReadAllText(pathPong);
        string obtener_numero = Texto.Remove(Texto.Length - 32);
        pongMax = int.Parse(obtener_numero);
    }
    public void setPong(int i)
    {
        pongMax = i;
        File.WriteAllText(pathPong, pongMax + " - es la mejor puntuacion arcade");
        
    }
    public int getPong()
    {
        return pongMax;
    }

}

