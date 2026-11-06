# LangChain Tutor

A simple LangChain program that asks an LLM "What is Kubernetes?" and prints the answer.

## Run it (Windows)

```
python -m venv .venv
.venv\Scripts\activate
pip install -r requirements.txt
copy .env.example .env
```

Edit `.env` and put in your Anthropic API key, then run:

```
python main.py
```
