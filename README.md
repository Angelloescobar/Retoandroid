# Retoandroid

# Aplicación Android: Chistes con JokeAPI

## 📌 Descripción
Este proyecto es una aplicación Android desarrollada en **Java** con **Android Studio**.  
Consume la [JokeAPI](https://v2.jokeapi.dev/joke/Any) para mostrar chistes en **español**, soportando ambos tipos de chistes:

- **Single:** una sola línea de chiste.  
- **Twopart:** chiste dividido en "setup" y "delivery".  

La aplicación incluye manejo de errores y un diseño simple con un `TextView` centrado y un botón para generar un nuevo chiste.

---

## 🛠️ Tecnologías y herramientas utilizadas

- **Lenguaje:** Java  
- **IDE:** Android Studio  
- **Librerías:**  
  - Retrofit → para las peticiones HTTP  
  - Gson → para deserializar JSON  
- **API externa:** [JokeAPI](https://v2.jokeapi.dev/)  
- **Asistente de desarrollo:** GitHub Copilot  

---

## 👥 Rol del desarrollador

- **Ronald:** desarrollo completo del proyecto, integración con la API, pruebas en dispositivo y documentación.  
*(Proyecto individual, todas las tareas realizadas por un solo desarrollador.)*

---

## Prompts utilizados con GitHub Copilot

**Prompt 1:**  
> Quiero que generes una aplicación Android en Java usando Android Studio.  
> La aplicación debe consumir la JokeAPI (https://v2.jokeapi.dev/joke/Any) para mostrar un chiste.  
> Requisitos: Retrofit, Gson, modelo de datos, manejo de errores, layout simple, idioma español.  

**Prompt 2:**  
> Necesito que los chistes aparecieran con idioma español.  

**Prompt 3:**  
> Genera el código en Java paso a paso, incluyendo:  
> - La interfaz de Retrofit (`JokeApiService`).  
> - El modelo de datos (`JokeResponse`).  
> - La clase `RetrofitClient`.  
> - El código de `MainActivity`.  
> - Un layout XML sencillo con `TextView` y `Button`.  

---

## Resultados obtenidos de cada prompt

- **Código generado:**  
  - Modelo de datos `JokeResponse.java` para ambos tipos de chistes.  
  - Interfaz `JokeApiService.java` para Retrofit.  
  - Clase `RetrofitClient.java` para la configuración de Retrofit y Gson.  
  - `MainActivity.java` con lógica para consumir la API, mostrar el chiste, manejar errores y recargar chistes.  
  - Layout `activity_main.xml` con un `TextView` centrado y un botón debajo.  
  - Instrucciones para subir el proyecto a GitHub.  

- **Errores:**  
  - Inicialmente, la API devolvía chistes en inglés. Se corrigió agregando el parámetro `lang=es` en la URL de la API.  

- **Mejoras:**  
  - Se mejoró el manejo de errores mostrando mensajes claros al usuario si falla la conexión o la API.  

---

## Problemas encontrados y cómo se resolvieron con IA

- **Problema 1:** Los chistes no aparecían en español.  
  - **Solución:** Se consultó a la IA y se agregó el parámetro `lang=es` en la llamada a la API.  

- **Problema 2:** Dificultad para manejar ambos tipos de chistes ("single" y "twopart") en el modelo de datos.  
  - **Solución:** La IA generó un modelo `JokeResponse` que soporta ambos tipos y lógica en la actividad principal para mostrar el formato correcto.  

---

## Reflexión final sobre la experiencia de usar herramientas de IA

El uso de **GitHub Copilot** facilitó la generación de código repetitivo y la integración de librerías como Retrofit y Gson.  
Permitió resolver rápidamente problemas comunes, como el manejo de diferentes formatos de respuesta de la API y la internacionalización.  

La IA fue útil para obtener ejemplos de código y buenas prácticas, acelerando el desarrollo y reduciendo errores.  
Sin embargo, fue necesario **revisar y adaptar** el código generado para ajustarlo a los requisitos específicos del proyecto.  

---

## 📂 Estructura del proyecto
