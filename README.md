# calculator-api-test

Consideraciones de diseño
=========================

Se han creado tests unitarios después de planificar la estructura de clases y los casos de uso a implementar, y se han creado finalmente las clases para cubrir las especificaciones de los tests.

No se han usado interfaces en determinados casos, como el servicio OperationService, para evitar caer en el uso innecesario de "interface with single implementation".

Se han utilizado DTOs en el controlador, realizando en este el mapeo al modelo para desacoplar cada versión del API del modelo, y permitir que los servicios de la aplicación trabajen en el ámbito del modelo, y no con DTOs.

Se ha creado una clase OperationMapper para mapear los DTOs a operaciones del modelo. Podría utilizarse alguna librería como ObjectMapper, pero por simplicidad del ejercicio se ha creado una clase propia.