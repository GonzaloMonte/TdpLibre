 using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class menu : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void StartBotones(string botonSeleccionado)
    {   if (botonSeleccionado.Equals("Exit"))
        {
            Application.Quit(0);
        }
        else
        {
            SceneManager.LoadScene(botonSeleccionado);
        }
    }
}
