package com.example;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;

/** A simple LangChain4j program that asks OpenAI: "What is Kubernetes?". */
public class LangchainCode {

    public static void main(String[] args) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Please set the OPENAI_API_KEY environment variable.");
            System.exit(1);
        }

        // 1. The model
        ChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gpt-4o-mini")
                .temperature(0.0)
                .build();

        // 2. The prompt, 3. the call
        ChatResponse response = model.chat(
                SystemMessage.from("You are a friendly tutor. Explain things simply, for a beginner."),
                UserMessage.from("What is Kubernetes?"));

        System.out.println(response.aiMessage().text());
    }
}
