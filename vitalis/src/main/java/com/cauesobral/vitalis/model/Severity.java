package com.cauesobral.vitalis.model;

// Grau de gravidade (fiz pensando na alergia, mas pode ser usado pra outras coisas que
//envolvem medir severidade também, por exemplo
// usar escala visual analógica que recebe input de nivel de dor de 0-9
//e classifica o grau de dor entre low, medium e high através de um calculo)
public enum Severity {
    LOW,
    MEDIUM,
    HIGH
}
