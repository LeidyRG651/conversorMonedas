<h1 align="center">💱 Conversor de Monedas 💱</h1> <p align="center"> <img src="src/img/moneda.png" alt="Logo del proyecto" width="150"> </p>
📋 Índice
Descripción del Proyecto
Tecnologías Utilizadas
API Consumida
Cómo Usar la Aplicación
Características Principales
Pruebas y Testing
Contribuciones
Licencia
📝 Descripción del Proyecto
El Conversor de Monedas es una herramienta que te permite convertir diferentes divisas de manera sencilla y rápida, utilizando tasas de cambio actualizadas en tiempo real. Gracias a la integración con la API de Exchange Rate, la aplicación obtiene las tasas de conversión más recientes para ofrecer resultados precisos.

🛠️ Tecnologías Utilizadas
Java 11 o versiones superiores.
Gson: Para el manejo y procesamiento de datos en formato JSON.
HttpClient: Utilizado para realizar peticiones HTTP hacia la API.
IDE recomendado: IntelliJ IDEA o cualquier otro compatible con Java.
🌐 API Consumida
Este proyecto utiliza la Exchange Rate API para obtener las tasas de cambio actualizadas.

URL Base:
https://app.exchangerate-api.com/dashboard/confirmed <API_KEY>/latest/

Nota: Reemplaza <API_KEY> con tu propia clave de API obtenida al registrarte en el sitio de Exchange Rate API. Mantén tu clave privada y evita compartirla en repositorios públicos.

🖥️ Cómo Usar la Aplicación
Inicia la aplicación desde tu IDE.
Introduce la cantidad que deseas convertir.
Selecciona las monedas de origen y destino.
Recibe la conversión de manera instantánea.
🚀 Características Principales
Conversión entre múltiples divisas como USD, EUR, GBP, JPY, CAD y COP.
Tasas de cambio actualizadas en tiempo real mediante la API.
Soporte para múltiples monedas (fácilmente extensible).
Conversión adicional automática a pesos colombianos (COP).
✅ Pruebas y Testing
Para probar el funcionamiento, puedes usar el código en tu IDE y realizar las siguientes pruebas:

Conversión entre diferentes pares de divisas.
Verificar la respuesta en caso de errores como tasas de cambio no disponibles.
🤝 Contribuciones
Si deseas contribuir a este proyecto, por favor sigue los pasos:

Haz un fork del repositorio.
Crea una nueva rama para tu funcionalidad o corrección de errores.
Realiza tus cambios y asegúrate de que todo funcione correctamente.
Envía un pull request con una descripción detallada.
📜 Licencia
Este proyecto está licenciado bajo la Licencia MIT, lo que significa que puedes usar, modificar y distribuir este software de manera libre.