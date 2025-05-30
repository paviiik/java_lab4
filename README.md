##  Лабораторная №4

1. Обработаны HTTP-ошибки 400, 404, 500
   - Используется GlobalExceptionHandler
   - Возвращается единый формат ответа ErrorResponse

2. Добавлено логирование действий и ошибок
   - Используется аспект LoggingAspect с аннотацией @Aspect
   - Логируются вызовы методов, результаты и исключения в пакетах com.phone..*

3. Подключены Swagger и CheckStyle

SonarCloud
https: //sonarcloud.io/organizations/paviiik-1/projects
