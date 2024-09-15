## Cadastro de Usuário
**Como** um contratante,  
**Eu preciso** me cadastrar no sistema com meus dados pessoais e profissionais,  
**Para que** eu possa utilizar o sistema de aluguel de carros.

### Critérios de Aceitação:
- O sistema deve permitir o cadastro de dados pessoais (RG, CPF, Nome, Endereço) e profissionais (profissão, empregadores e rendimentos).
- O cadastro só será concluído se todos os campos obrigatórios forem preenchidos e validados.
- Após o cadastro, uma confirmação deve ser enviada por e-mail ou notificação no sistema.
- O contratante só poderá utilizar o sistema após a aprovação do cadastro.

---

## Introdução de Pedido de Aluguel
**Como** um contratante,  
**Eu preciso** introduzir um pedido de aluguel de automóvel,  
**Para que** eu possa solicitar o aluguel de um carro no sistema.

### Critérios de Aceitação:
- O contratante deve poder selecionar um automóvel disponível no sistema.
- O pedido deve incluir o automóvel, datas de aluguel e preferências adicionais.
- O pedido será salvo com o status "Pendente" até análise de um agente.
- O sistema deve enviar uma confirmação visual e por e-mail após a introdução do pedido.

---

## Modificação de Pedido de Aluguel
**Como** um contratante,  
**Eu preciso** modificar um pedido de aluguel existente,  
**Para que** eu possa ajustar as informações do meu pedido antes da execução do contrato.

### Critérios de Aceitação:
- O contratante pode modificar os pedidos com status "Pendente" antes da execução do contrato.
- O sistema deve permitir a alteração de detalhes como datas, automóvel selecionado e preferências.
- O contratante receberá uma confirmação ao finalizar a modificação do pedido.

---

## Consulta de Pedidos de Aluguel
**Como** um contratante,  
**Eu preciso** consultar meus pedidos de aluguel,  
**Para que** eu possa acompanhar o status de cada um dos meus pedidos.

### Critérios de Aceitação:
- O contratante deve ter acesso a uma lista de todos os seus pedidos de aluguel, incluindo o status (Pendente, Aprovado, Rejeitado, Cancelado).
- Cada pedido deve mostrar detalhes como o automóvel selecionado, datas de aluguel e valor estimado.
- O contratante pode filtrar ou ordenar os pedidos por data, status ou veículo.

---

## Cancelamento de Pedido de Aluguel
**Como** um contratante,  
**Eu preciso** cancelar um pedido de aluguel,  
**Para que** eu possa desistir do aluguel de um carro caso necessário.

### Critérios de Aceitação:
- O sistema deve permitir o cancelamento de pedidos com status "Pendente".
- O contratante deve receber uma confirmação antes de o cancelamento ser finalizado.
- O status do pedido deve ser atualizado para "Cancelado" após o processo.
- Um e-mail ou notificação será enviado ao contratante confirmando o cancelamento.

---

## Avaliação de Pedido de Aluguel (Agente)
**Como** um agente (empresa ou banco),  
**Eu preciso** avaliar os pedidos de aluguel dos contratantes,  
**Para que** eu possa determinar se o contrato de aluguel deve ser aprovado financeiramente.

### Critérios de Aceitação:
- O agente deve ser capaz de visualizar todos os pedidos de aluguel com status "Pendente" em uma lista.
- Cada pedido deve conter informações do contratante e os detalhes do pedido.
- O agente deve poder aprovar ou rejeitar um pedido com base na análise financeira.
- Após a decisão, o contratante receberá uma notificação do status atualizado (Aprovado ou Rejeitado).

---

## Modificação de Pedido por Agente
**Como** um agente (empresa ou banco),  
**Eu preciso** modificar os pedidos de aluguel dos contratantes,  
**Para que** eu possa ajustar informações críticas antes da avaliação final.

### Critérios de Aceitação:
- O agente deve ser capaz de modificar informações críticas de pedidos antes da aprovação final (ex: datas, detalhes financeiros).
- Qualquer modificação feita pelo agente deve ser registrada e notificada ao contratante.
- O sistema deve garantir que apenas agentes autorizados possam fazer essas modificações.

---

## Execução do Contrato de Aluguel
**Como** um contratante ou agente,  
**Eu preciso** executar o contrato de aluguel após a aprovação do pedido,  
**Para que** o aluguel do carro seja formalmente realizado e o automóvel registrado conforme o tipo de contrato.

### Critérios de Aceitação:
- Após a aprovação do pedido, o contrato de aluguel deve ser gerado automaticamente e disponibilizado para ambas as partes (contratante e agente).
- O sistema deve permitir que o contratante e o agente visualizem o contrato antes da execução.
- O contrato só será considerado "Executado" após a confirmação de ambas as partes.
- Um registro do automóvel e contrato será atualizado no sistema para consultas futuras.

---

## Registro de Automóveis
**Como** um agente,  
**Eu preciso** registrar os automóveis alugados no sistema,  
**Para que** as informações dos veículos estejam corretas e disponíveis para consulta.

### Critérios de Aceitação:
- O sistema deve permitir que os agentes registrem novos automóveis com informações como matrícula, marca, modelo, ano e placa.
- O sistema deve validar se os campos obrigatórios do automóvel estão preenchidos corretamente antes de permitir o registro.
- Após o registro, o automóvel deve estar disponível para pedidos de aluguel.

---

## Associação de Contrato de Crédito
**Como** um agente de banco,  
**Eu preciso** associar um contrato de crédito ao aluguel de um automóvel,  
**Para que** o contratante possa financiar o aluguel por meio de um empréstimo bancário.

### Critérios de Aceitação:
- O sistema deve permitir a associação de um contrato de crédito aprovado ao pedido de aluguel.
- Somente agentes bancários autorizados podem fazer a associação de contratos de crédito.
- A associação deve ser confirmada pelo contratante antes de ser efetivada.
- O sistema deve registrar e exibir informações detalhadas do crédito associado ao contrato.

---

## Conexão com Servidor Central
**Como** um usuário do sistema,  
**Eu preciso** que o sistema esteja conectado ao servidor central,  
**Para que** todas as operações sejam realizadas de forma centralizada e sincronizada com os agentes e contratantes.

### Critérios de Aceitação:
- O sistema deve garantir que todas as operações de pedidos, contratos e registros sejam sincronizadas com o servidor central.
- O sistema deve exibir uma notificação de erro se houver falha na conexão com o servidor central.
- Todas as alterações feitas em pedidos ou contratos devem ser registradas e sincronizadas em tempo real com o servidor central e os agentes envolvidos.
