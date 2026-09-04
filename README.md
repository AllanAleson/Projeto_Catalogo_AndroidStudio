# Catálogo de Produtos

Aplicativo Android desenvolvido individualmente em **Java** para a disciplina de Programação de Dispositivos Móveis II.

## Funcionalidades

- tela principal com uma imagem em destaque;
- seleção entre três produtos por imagens menores;
- indicação e preservação do produto selecionado;
- botão **DETALHES** com navegação para uma Activity específica de cada produto;
- telas com foto, nome, descrição e informações adicionais;
- botão **VOLTAR** em cada tela de detalhes;
- botão **LIMPAR** para remover a seleção e restaurar a tela inicial.

## Activities

- `MainActivity`: catálogo e seleção;
- `HeadphonesActivity`: detalhes dos Fones Aurora;
- `CameraActivity`: detalhes da Câmera Prisma;
- `NotebookActivity`: detalhes do Notebook Vision Pro.

## Como executar

1. Abra a pasta do projeto no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Execute o módulo `app` em um dispositivo ou emulador com Android 7.0 (API 24) ou superior.

Para compilar pelo terminal no Windows:

```powershell
.\gradlew.bat assembleDebug
```

O APK será criado em `app/build/outputs/apk/debug/app-debug.apk`.
