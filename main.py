"""A simple LangChain program that asks an LLM: "What is Kubernetes?"."""

from dotenv import load_dotenv
from langchain_anthropic import ChatAnthropic
from langchain_core.output_parsers import StrOutputParser
from langchain_core.prompts import ChatPromptTemplate

# Reads ANTHROPIC_API_KEY from a .env file (or your environment).
load_dotenv()

# 1. The model
llm = ChatAnthropic(model="claude-sonnet-5-5", temperature=0)

# 2. The prompt template
prompt = ChatPromptTemplate.from_messages(
    [
        ("system", "You are a friendly tutor. Explain things simply, for a beginner."),
        ("human", "{question}"),
    ]
)

# 3. Chain them together: prompt -> model -> plain text
chain = prompt | llm | StrOutputParser()

if __name__ == "__main__":
    answer = chain.invoke({"question": "What is Kubernetes?"})
    print(answer)
