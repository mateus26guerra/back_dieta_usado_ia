package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Usuario.Uenum.Sexo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelCompletoIaResponse;

import java.util.Map;

public class PdfCompletoTemplate {

    public static String gerarHtml(
            PlanoNivelCompletoIaResponse ia,
            String nomeUsuario,
            double idade,
            Sexo sexo,
            double metaAguaLitros,
            double metaAguaLitrosSemAtividadeFisica
    ) {

        return "<!DOCTYPE html>" +
                "<html><head><meta charset='UTF-8'/>" +
                "<style>" +
                "body{font-family:Segoe UI,Arial;padding:40px;color:#1a1a1a}" +
                "h1{color:#1e40af;border-bottom:3px solid #3b82f6}" +
                "h2{color:#1e3a8a;margin-top:30px}" +
                "h3{color:#2563eb}" +
                ".card{background:#f8fafc;padding:24px;margin-bottom:20px;border-left:4px solid #3b82f6;border-radius:8px}" +
                ".page-break{page-break-before:always}" +
                "table{width:100%;border-collapse:collapse;margin-top:20px}" +
                "th,td{border:1px solid #cbd5e1;padding:10px;text-align:center}" +
                "th{background:#1e40af;color:white}" +
                "</style></head><body>" +

                "<h1>Plano Nutricional Completo</h1>" +
                "<p><strong>Paciente:</strong> " + xmlSafe(nomeUsuario) + "<strong> Gênero: </strong>"+ xmlSafe(String.valueOf(sexo)) + "</p>" +
                "<p><strong>Idade:</strong> " + xmlSafe(String.valueOf(idade)) + "</p>" +

                card("Objetivo", ia.plano.objetivo) +
                card("Descrição do Plano", ia.plano.descricao) +
                card("Plano de Dieta", ia.conteudo.plano_de_dieta) +

                "<div class='page-break'></div>" +
                "<h1>Cardápio Semanal (7 dias)</h1>" +
                "<div class='card'>" +
                formatarCardapio7Dias(ia.conteudo.cardapio_7_dias) +
                "</div>" +

                "<div class='page-break'></div>" +
                "<h1>Atividade Física</h1>" +
                "<div class='card'>" +
                formatarAtividadeFisica(ia.conteudo.atividade_fisica) +
                "</div>" +

                "<h1>Orientações Gerais</h1>" +
                card("", ia.conteudo.orientacoes_gerais) +

                "<div class='page-break'></div>" +

                "<div class='page-break'></div>" +
                "<h1>Tabela Semanal de Exercícios</h1>" +
                "<div class='card'>" +
                formatarTabelaExercicios(ia.conteudo.tabela_exercicios) +
                "</div>" +

                "<h1>Hidratação</h1>" +
                card("Meta com atividade física", metaAguaLitros + " L/dia") +
                card("Meta sem atividade física", metaAguaLitrosSemAtividadeFisica + " L/dia") +
                "<p> </p>" +
                "<p> </p>" +
                "<p> </p>" +

                "<div class='page-break'></div>" +
                "<h1>Bingo de Hábitos</h1>" +
                gerarRegrasBingo() +
                gerarTabelaBingo() +


                "<table>" +
                "<h1>Tabela de Hidratação</h1>" +
                "<tr><th>Dia</th><th>Meta (L)</th><th>Consumido</th><th>Status</th></tr>" +
                gerarLinhasTabelaAgua(metaAguaLitros) +
                "</table>" +
                "<div class='page-break'></div>" +
                "<h1>Controle Mensal de Frequência na Academia</h1>" +
                "<div class='card'>" +
                gerarTabelaPresencaMensalAcademia() +
                "</div>" +
                "<div class='page-break'></div>" +
                "<h1>Meta Mensal de Cardio</h1>" +
                gerarRegrasMetaCardio() +
                gerarTabelaMetaCardio() +


                "</body></html>";
    }

    private static String card(String titulo, String conteudo) {
        return "<div class='card'>" +
                (titulo.isEmpty() ? "" : "<h2>" + titulo + "</h2>") +
                "<p>" + xmlSafe(conteudo) + "</p></div>";
    }

    private static String formatarCardapio7Dias(
            Map<String, PlanoNivelCompletoIaResponse.DiaCardapio> cardapio
    ) {
        if (cardapio == null) return "";

        StringBuilder sb = new StringBuilder();
        cardapio.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    var d = entry.getValue();
                    sb.append("<h3>").append(xmlSafe(entry.getKey())).append("</h3><ul>")
                            .append("<li><b>Café:</b> ").append(xmlSafe(d.cafe)).append("</li>")
                            .append("<li><b>Almoço:</b> ").append(xmlSafe(d.almoco)).append("</li>")
                            .append("<li><b>Lanche:</b> ").append(xmlSafe(d.lanche)).append("</li>")
                            .append("<li><b>Jantar:</b> ").append(xmlSafe(d.jantar)).append("</li>")
                            .append("<li><b>Ceia:</b> ").append(xmlSafe(d.ceia)).append("</li>")
                            .append("</ul>");
                });
        return sb.toString();
    }

    private static String formatarAtividadeFisica(
            PlanoNivelCompletoIaResponse.AtividadeFisica a
    ) {
        if (a == null) return "<p>Não informado</p>";

        return "<ul>" +
                "<li><b>Musculação:</b> " + xmlSafe(a.musculacao) + "</li>" +
                "<li><b>Cardio:</b> " + xmlSafe(a.cardio) + "</li>" +
                "<li><b>Core:</b> " + xmlSafe(a.core) + "</li>" +
                "</ul>";
    }

    private static String gerarLinhasTabelaAgua(double meta) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 31; i++) {
            sb.append("<tr><td>").append(i).append("</td>")
                    .append("<td>").append(String.format("%.1f", meta)).append("</td>")
                    .append("<td></td><td></td></tr>");
        }
        return sb.toString();
    }

    private static String xmlSafe(String t) {
        if (t == null) return "";
        return t.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private static String formatarTabelaExercicios(Map<String, String> tabela) {
        if (tabela == null || tabela.isEmpty()) {
            return "<p>Treinos não informados.</p>";
        }

        // Ordem correta da semana
        String[] ordemSemana = {
                "Segunda",
                "Terça",
                "Quarta",
                "Quinta",
                "Sexta",
                "Sábado",
                "Domingo"
        };

        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<tr><th>Dia</th><th>Treino</th></tr>");

        for (String dia : ordemSemana) {
            if (tabela.containsKey(dia)) {
                sb.append("<tr>")
                        .append("<td>").append(xmlSafe(dia)).append("</td>")
                        .append("<td>").append(xmlSafe(tabela.get(dia))).append("</td>")
                        .append("</tr>");
            }
        }

        sb.append("</table>");
        return sb.toString();
    }

    private static String gerarTabelaPresencaMensalAcademia() {

        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<tr><th>Dia</th><th>Fui treinar?</th></tr>");

        for (int dia = 1; dia <= 30; dia++) {
            sb.append("<tr>")
                    .append("<td>").append(dia).append("</td>")
                    .append("<td>sim [__] / nao [__] - horaio ___:___ </td>")
                    .append("</tr>");
        }

        sb.append("</table>");
        return sb.toString();
    }


    private static String gerarRegrasBingo() {
        return "<div class='card'>" +
                "<h2>Regras do Bingo de Hábitos</h2>" +
                "<ul>" +
                "<li>Você só pode marcar <b>1 hábito por dia</b>.</li>" +
                "<li>Ao completar <b>1 linha horizontal</b>, você pode comer <b>1 besteira</b>.</li>" +
                "<li>Ao completar <b>2 linhas horizontais</b>, você pode faltar <b>1 dia da academia sem culpa</b>.</li>" +
                "<li>Ao completar <b>3 linhas horizontais</b>, você pode descansar e comer besteira.</li>" +
                "<li>O objetivo é criar constância, não perfeição.</li>" +
                "</ul>" +
                "</div>";
    }


    private static String gerarTabelaBingo() {
        return "<table>" +

                "<tr>" +
                "<td>Beber bastante água o dia todo</td>" +
                "<td>Fazer exercício físico</td>" +
                "<td>Pular corda por 10 minutos</td>" +
                "<td>Comer 4 frutas no dia</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Caminhar 30 minutos</td>" +
                "<td>Evitar açúcar</td>" +
                "<td>Alongar por 15 minutos</td>" +
                "<td>Comer só comida limpa</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Dormir bem</td>" +
                "<td>Ficar 1 hora sem celular</td>" +
                "<td>Treino abdominal</td>" +
                "<td>Dia livre / bônus</td>" +
                "</tr>" +

                "</table>";
    }
    private static String gerarRegrasMetaCardio() {
        return "<div class='card'>" +
                "<h2>Meta de Cardio</h2>" +
                "<ul>" +
                "<li>Escolha apenas <b>um tipo de cardio por dia</b>.</li>" +
                "<li>Você pode alternar entre caminhada, corrida, pular corda ou outro cardio.</li>" +
                "<li>O tempo mínimo recomendado é <b>20 a 30 minutos</b>.</li>" +
                "<li>Marque o dia como concluído apenas se completar o tempo.</li>" +
                "<li>Consistência é mais importante que intensidade.</li>" +
                "</ul>" +
                "</div>";
    }
    private static String gerarTabelaMetaCardio() {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>");
        sb.append("<tr>")
                .append("<th>Dia</th>")
                .append("<th>Tipo de Cardio</th>")
                .append("<th>Tempo (min)</th>")
                .append("<th>Concluído</th>")
                .append("</tr>");

        for (int i = 1; i <= 30; i++) {
            sb.append("<tr>")
                    .append("<td>").append(i).append("</td>")
                    .append("<td></td>")
                    .append("<td></td>")
                    .append("<td></td>")
                    .append("</tr>");
        }

        sb.append("</table>");
        return sb.toString();
    }


}
