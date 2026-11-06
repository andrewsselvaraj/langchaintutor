package com.example;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.anthropic.AnthropicChatModel;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;

/** A simple LangChain4j program that asks an LLM: "What is Kubernetes?". */
public class WhatIsKubernetes {

    public static void main(String[] args) {
        String apiKey = System.getenv("ANTHROPIC_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.err.println("Please set the ANTHROPIC_API_KEY environment variable.");
            System.exit(1);
        }

        // 1. The model
        ChatModel model = AnthropicChatModel.builder()
                .apiKey(apiKey)
                .modelName("claude-sonnet-5-5")
                .temperature(0.0)
                .maxTokens(1024)
                .build();

        // 2. The prompt, 3. the call
        ChatResponse response = model.chat(
                SystemMessage.from("You are a friendly tutor. Explain things simply, for a beginner."),
                UserMessage.from("What is Kubernetes?"));

        System.out.println(response.aiMessage().text());
    }
}
