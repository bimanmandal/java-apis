## Annotations

### What is Annotation?
>Annotations, a form of metadata, provide data about a program that is not part of the program itself. 
>Annotations have no direct effect on the operation of the code they annotate.


### Different Format of Annotation
```java
@Entity
@Author(name = "Biman", place = "Bangalore")
@Author("Biman") // if one element then name can be omitted
```

*It is also possible to declare multiple annotations*
```java
@Book
@Author(name = "Biman Mandal")
class MyBook { ... }
```

***Repeating Annotation:** Annotation having same type*
```java
@Author(name = "Biman Mandal")
@Author(name = "Samik Bandopadhyay")
class MyBook { ... }
```
### Where annotations can be used
Annotations can be used infornt of 
1. Class
2. Fields
3. Methods
4. Interface
5. Types

### Predefined Annotations
#### Annotations used by Java
```java
1. @Deprecated
2. @Override
3. @SuppressWarnings("...")
4. @SafeVarargs
5. @FunctionalInterface
```
#### Annotations that apply on other annotations
```java
1. @Retention
2. @Documented
3. @Target 
4. @Inherited 
5. @Repeatable 
```

