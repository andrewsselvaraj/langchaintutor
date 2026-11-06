# LangChain Tutor (Java)

A simple standalone Java program, built with [LangChain4j](https://docs.langchain4j.dev),
that asks an LLM "What is Kubernetes?" and prints the answer.

## Requirements

- Java 17 or newer
- Maven
- An Anthropic API key

## Run it (Windows)

```
set ANTHROPIC_API_KEY=your-api-key-here
mvn package
java -jar target\langchaintutor.jar
```

`mvn package` builds a single runnable jar (`target\langchaintutor.jar`) with everything inside,
so after that you only need `java -jar` to run it.
