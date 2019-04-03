using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class bola : MonoBehaviour
{
    int velocidadX;
    int velocidadY;

    float speed;
    
    void Start()
    {
        Moverse();
    }

    void Update()
    {
        if (juego.getMaximoPuntaje() == juego.getPuntaje1())
        {
            Reset();
        }
        if (juego.getMaximoPuntaje() == juego.getPuntaje2())
        {
            Reset();
        }
    }

    void Moverse()
    {
        velocidadX = DevolverVelocidad();
        velocidadY = DevolverVelocidad();

        speed = Random.Range(7, 10);

        GetComponent<Rigidbody>().velocity = new Vector3(speed * velocidadX, speed * velocidadY, 0);

    }

    int DevolverVelocidad()
    {
        int retornar = Random.Range(0, 2);

        if (retornar == 0)
        {
            retornar = 1;
        }
        else retornar = -1;

        return retornar;
    }

    void Reset()
    {
        transform.localPosition = new Vector3(0, 0, 0);
        GetComponent<Rigidbody>().velocity =new Vector3(0, 0, 0);
        
    }


    private void OnCollisionEnter(Collision collision)
    {
        if (collision.collider.tag == "player1gol")
        {
            juego.sumarPuntaje2();
            Reset();
            Invoke("Moverse", 2);
        }
        else if (collision.collider.tag == "player2gol")
        {
            juego.sumarPuntaje1();
            Reset();
            Invoke("Moverse", 2);
        }


      }


}
