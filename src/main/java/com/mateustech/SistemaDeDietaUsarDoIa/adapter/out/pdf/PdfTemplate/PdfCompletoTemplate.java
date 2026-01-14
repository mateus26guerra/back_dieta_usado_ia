package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Usuario.Uenum.Sexo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelCompletoIaResponse;

import java.util.Map;
import java.util.stream.Collectors;

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
                "* { margin: 0; padding: 0; box-sizing: border-box; }" +
                "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; padding: 35px; color: #2c3e50; background: #ffffff; line-height: 1.6; }" +

                "h1 { color: #1e3a8a; font-size: 28px; margin-bottom: 20px; padding-bottom: 12px; border-bottom: 4px solid #3b82f6; text-transform: uppercase; letter-spacing: 1px; }" +
                "h2 { color: #2563eb; font-size: 22px; margin-top: 25px; margin-bottom: 15px; }" +
                "h3 { color: #1e40af; font-size: 18px; margin-top: 20px; margin-bottom: 10px; padding-left: 10px; border-left: 4px solid #60a5fa; }" +

                ".header-info { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: #ffffff; padding: 25px; border-radius: 12px; margin-bottom: 30px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }" +
                ".header-info .titulo-principal { color: #1e3a8a; font-size: 32px; font-weight: bold; border: none; margin-bottom: 15px; background: white; padding: 15px; border-radius: 8px; text-align: center; }" +
                ".header-info p { margin: 8px 0; font-size: 16px; color: #ffffff; }" +
                ".header-info strong { font-weight: 600; color: #ffffff; }" +

                ".card { background: linear-gradient(to right, #f8fafc, #ffffff); padding: 20px 25px; margin-bottom: 20px; border-left: 5px solid #3b82f6; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.08); }" +
                ".card h2 { margin-top: 0; color: #1e40af; }" +
                ".card p { color: #475569; font-size: 15px; }" +

                ".card-destaque { background: linear-gradient(135deg, #e0f2fe 0%, #bfdbfe 100%); border-left: 5px solid #0284c7; }" +

                ".page-break { page-break-before: always; }" +

                "table { width: 100%; border-collapse: collapse; margin-top: 20px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); border-radius: 8px; overflow: hidden; }" +
                "th { background: linear-gradient(135deg, #1e40af 0%, #3b82f6 100%); color: white; padding: 14px 12px; text-align: center; font-weight: 600; font-size: 14px; text-transform: uppercase; letter-spacing: 0.5px; }" +
                "td { border: 1px solid #e2e8f0; padding: 12px 10px; text-align: center; font-size: 14px; background: white; }" +
                "tr:nth-child(even) td { background: #f8fafc; }" +
                "tr:hover td { background: #e0f2fe; transition: background 0.2s; }" +

                ".dia-label { font-weight: 600; color: #1e40af; }" +

                "ul { list-style: none; padding-left: 0; }" +
                "ul li { padding: 8px 0; padding-left: 25px; position: relative; color: #475569; font-size: 15px; }" +
                "ul li:before { content: '\\2713'; position: absolute; left: 0; color: #3b82f6; font-weight: bold; font-size: 18px; }" +
                "ul li b { color: #1e40af; }" +

                ".refeicao-list { background: white; padding: 15px; border-radius: 6px; margin-top: 10px; }" +
                ".refeicao-list li { border-bottom: 1px solid #e2e8f0; padding: 10px 0; }" +
                ".refeicao-list li:last-child { border-bottom: none; }" +
                ".refeicao-list li:before { content: '\\25BA'; color: #3b82f6; }" +

                ".regras-card { background: linear-gradient(135deg, #fef3c7 0%, #fde68a 100%); border-left: 5px solid #f59e0b; padding: 20px; border-radius: 8px; margin-bottom: 20px; }" +
                ".regras-card h2 { color: #92400e; margin-bottom: 15px; }" +
                ".regras-card ul li:before { content: '\\2605'; color: #f59e0b; }" +

                ".regras-card-compacta { background: linear-gradient(135deg, #fef3c7 0%, #fde68a 100%); border-left: 5px solid #f59e0b; padding: 15px 20px; border-radius: 8px; margin-bottom: 15px; }" +
                ".regras-card-compacta h2 { color: #92400e; margin-bottom: 10px; font-size: 18px; }" +
                ".regras-card-compacta ul { margin-top: 8px; }" +
                ".regras-card-compacta ul li { padding: 5px 0; padding-left: 20px; font-size: 14px; }" +
                ".regras-card-compacta ul li:before { content: '\\2022'; color: #f59e0b; font-size: 16px; }" +

                ".tabela-container { margin-top: 20px; margin-bottom: 30px; }" +

                "@media print {" +
                "  body { padding: 20px; }" +
                "  .page-break { page-break-before: always; }" +
                "  .card, table { box-shadow: none; }" +
                "}" +
                "</style></head><body>" +

                // Cabeçalho
                "<div class='header-info'>" +
                "<div class='titulo-principal'>PLANO NUTRICIONAL COMPLETO</div>" +
                "<p><strong>Paciente:</strong> " + xmlSafe(nomeUsuario) + "</p>" +
                "<p><strong>Genero:</strong> " + xmlSafe(String.valueOf(sexo)) + " | <strong>Idade:</strong> " + xmlSafe(String.valueOf((int)idade)) + " anos</p>" +
                "</div>" +

                cardDestaque("-> Objetivo", ia.plano.objetivo) +
                card("-> Descricao do Plano", ia.plano.descricao) +
                card("-> Plano de Dieta", ia.conteudo.plano_de_dieta) +

                // Cardápio Semanal - 2 dias por página
                "<div class='page-break'></div>" +
                "<h1>-> CARDAPIO SEMANAL - Dias 1 e 2</h1>" +
                "<div class='card-destaque card'>" +
                formatarCardapioParcial(ia.conteudo.cardapio_7_dias, 0, 2) +
                "</div>" +

                "<div class='page-break'></div>" +
                "<h1>-> CARDAPIO SEMANAL - Dias 3 e 4</h1>" +
                "<div class='card-destaque card'>" +
                formatarCardapioParcial(ia.conteudo.cardapio_7_dias, 2, 4) +
                "</div>" +

                "<div class='page-break'></div>" +
                "<h1>-> CARDAPIO SEMANAL - Dias 5 e 6</h1>" +
                "<div class='card-destaque card'>" +
                formatarCardapioParcial(ia.conteudo.cardapio_7_dias, 4, 6) +
                "</div>" +

                "<div class='page-break'></div>" +
                "<h1>-> CARDAPIO SEMANAL - Dia 7</h1>" +
                "<div class='card-destaque card'>" +
                formatarCardapioParcial(ia.conteudo.cardapio_7_dias, 6, 7) +
                "</div>" +

                // Atividade Física
                "<div class='page-break'></div>" +
                "<h1>-> ATIVIDADE FISICA</h1>" +
                "<div class='card'>" +
                formatarAtividadeFisica(ia.conteudo.atividade_fisica) +
                "</div>" +

                "<h1>-> ORIENTACOES GERAIS</h1>" +
                card("", ia.conteudo.orientacoes_gerais) +

                // Tabela de Exercícios
                "<div class='page-break'></div>" +
                "<h1>-> TABELA SEMANAL DE EXERCICIOS</h1>" +
                "<div class='tabela-container'>" +
                formatarTabelaExercicios(ia.conteudo.tabela_exercicios) +
                "</div>" +

                // Hidratação
                "<h1>-> METAS DE HIDRATACAO</h1>" +
                cardDestaque("-> Meta com atividade fisica", metaAguaLitros + " L/dia") +
                cardDestaque("-> Meta sem atividade fisica", metaAguaLitrosSemAtividadeFisica + " L/dia") +

                // Tabela de Hidratação - Dias 1-15
                "<div class='page-break'></div>" +
                "<h1>-> CONTROLE DE HIDRATACAO - Dias 1 a 15</h1>" +
                "<div class='tabela-container'>" +
                "<table>" +
                "<tr><th>Dia</th><th>Meta (L)</th><th>Consumido (L)</th><th>Status</th></tr>" +
                gerarLinhasTabelaAgua(metaAguaLitros, 1, 15) +
                "</table>" +
                "</div>" +

                // Tabela de Hidratação - Dias 16-30
                "<div class='page-break'></div>" +
                "<h1>-> CONTROLE DE HIDRATACAO - Dias 16 a 30</h1>" +
                "<div class='tabela-container'>" +
                "<table>" +
                "<tr><th>Dia</th><th>Meta (L)</th><th>Consumido (L)</th><th>Status</th></tr>" +
                gerarLinhasTabelaAgua(metaAguaLitros, 16, 30) +
                "</table>" +
                "</div>" +

                // Controle de Academia - Dias 1-15
                "<div class='page-break'></div>" +
                "<h1>-> CONTROLE DE FREQUENCIA - Dias 1 a 15</h1>" +
                "<div class='tabela-container'>" +
                gerarTabelaPresencaMensalAcademia(1, 15) +
                "</div>" +

                // Controle de Academia - Dias 16-30
                "<div class='page-break'></div>" +
                "<h1>-> CONTROLE DE FREQUENCIA - Dias 16 a 30</h1>" +
                "<div class='tabela-container'>" +
                gerarTabelaPresencaMensalAcademia(16, 30) +
                "</div>" +

                // Meta de Cardio - Dias 1-13
                "<div class='page-break'></div>" +
                "<h1>-> META MENSAL DE CARDIO - Dias 1 a 13</h1>" +
                gerarRegrasMetaCardioCompacta() +
                "<div class='tabela-container'>" +
                gerarTabelaMetaCardio(1, 13) +
                "</div>" +

                // Meta de Cardio - Dias 14-30
                "<div class='page-break'></div>" +
                "<h1>-> META MENSAL DE CARDIO - Dias 14 a 30</h1>" +
                "<div class='tabela-container'>" +
                gerarTabelaMetaCardio(14, 30) +
                "</div>" +

                // Bingo de Hábitos
                "<div class='page-break'></div>" +
                "<h1>-> BINGO DE HABITOS SAUDAVEIS</h1>" +
                gerarRegrasBingo() +
                "<div class='tabela-container'>" +
                gerarTabelaBingo() +
                "</div>" +

                "</body></html>";
    }

    private static String card(String titulo, String conteudo) {
        return "<div class='card'>" +
                (titulo.isEmpty() ? "" : "<h2>" + titulo + "</h2>") +
                "<p>" + xmlSafe(conteudo) + "</p></div>";
    }

    private static String cardDestaque(String titulo, String conteudo) {
        return "<div class='card card-destaque'>" +
                (titulo.isEmpty() ? "" : "<h2>" + titulo + "</h2>") +
                "<p>" + xmlSafe(conteudo) + "</p></div>";
    }

    private static String formatarCardapioParcial(
            Map<String, PlanoNivelCompletoIaResponse.DiaCardapio> cardapio,
            int inicio,
            int fim
    ) {
        if (cardapio == null) return "<p>Cardapio nao informado</p>";

        StringBuilder sb = new StringBuilder();

        var diasOrdenados = cardapio.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        for (int i = inicio; i < fim && i < diasOrdenados.size(); i++) {
            var entry = diasOrdenados.get(i);
            var d = entry.getValue();

            sb.append("<h3>").append(xmlSafe(entry.getKey())).append("</h3>")
                    .append("<div class='refeicao-list'><ul>")
                    .append("<li><b>--  Cafe da Manha:</b> ").append(xmlSafe(d.cafe)).append("</li>")
                    .append("<li><b>--  Almoco:</b> ").append(xmlSafe(d.almoco)).append("</li>")
                    .append("<li><b>--  Lanche:</b> ").append(xmlSafe(d.lanche)).append("</li>")
                    .append("<li><b>--  Jantar:</b> ").append(xmlSafe(d.jantar)).append("</li>")
                    .append("<li><b>-- Ceia:</b> ").append(xmlSafe(d.ceia)).append("</li>")
                    .append("</ul></div>");
        }

        return sb.toString();
    }

    private static String formatarAtividadeFisica(
            PlanoNivelCompletoIaResponse.AtividadeFisica a
    ) {
        if (a == null) return "<p>Nao informado</p>";

        return "<ul>" +
                "<li><b> -> Musculacao:</b> " + xmlSafe(a.musculacao) + "</li>" +
                "<li><b> -> Cardio:</b> " + xmlSafe(a.cardio) + "</li>" +
                "<li><b> -> Core:</b> " + xmlSafe(a.core) + "</li>" +
                "</ul>";
    }

    private static String gerarLinhasTabelaAgua(double meta, int diaInicio, int diaFim) {
        StringBuilder sb = new StringBuilder();
        for (int i = diaInicio; i <= diaFim; i++) {
            sb.append("<tr>")
                    .append("<td class='dia-label'>").append(i).append("</td>")
                    .append("<td>").append(String.format("%.1f", meta)).append("</td>")
                    .append("<td></td>")
                    .append("<td></td>")
                    .append("</tr>");
        }
        return sb.toString();
    }

    private static String xmlSafe(String t) {
        if (t == null) return "";
        return t.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private static String formatarTabelaExercicios(Map<String, String> tabela) {
        if (tabela == null || tabela.isEmpty()) {
            return "<p>Treinos nao informados.</p>";
        }

        String[] ordemSemana = {
                "Segunda", "Terca", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo"
        };

        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<tr><th>Dia da Semana</th><th>Treino</th></tr>");

        for (String dia : ordemSemana) {
            if (tabela.containsKey(dia)) {
                sb.append("<tr>")
                        .append("<td class='dia-label'>").append(xmlSafe(dia)).append("</td>")
                        .append("<td>").append(xmlSafe(tabela.get(dia))).append("</td>")
                        .append("</tr>");
            }
        }

        sb.append("</table>");
        return sb.toString();
    }

    private static String gerarTabelaPresencaMensalAcademia(int diaInicio, int diaFim) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<tr><th>Dia</th><th>Fui Treinar?</th><th>Horario</th></tr>");

        for (int dia = diaInicio; dia <= diaFim; dia++) {
            sb.append("<tr>")
                    .append("<td class='dia-label'>").append(dia).append("</td>")
                    .append("<td>Sim [__] / Nao [__]</td>")
                    .append("<td>___:___</td>")
                    .append("</tr>");
        }

        sb.append("</table>");
        return sb.toString();
    }

    private static String gerarRegrasBingo() {
        return "<div class='regras-card'>" +
                "<h2>-> Regras do Bingo</h2>" +
                "<ul>" +
                "<li>Voce so pode marcar <b>1 habito por dia</b></li>" +
                "<li>Ao completar <b>1 linha horizontal</b>: pode comer <b>1 besteira</b></li>" +
                "<li>Ao completar <b>2 linhas horizontais</b>: pode faltar <b>1 dia da academia</b> sem culpa</li>" +
                "<li>Ao completar <b>3 linhas horizontais</b>: dia livre completo</li>" +
                "<li><b>Importante:</b> O objetivo e criar constancia, nao perfeicao!</li>" +
                "</ul>" +
                "</div>";
    }

    private static String gerarTabelaBingo() {
        return "<table>" +
                "<tr>" +
                "<td>Beber bastante agua</td>" +
                "<td>Exercicio fisico</td>" +
                "<td>Pular corda 10min</td>" +
                "<td>Comer 4 frutas</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Caminhar 30min</td>" +
                "<td>Evitar acucar</td>" +
                "<td>Alongar 15min</td>" +
                "<td>Comida limpa</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Dormir bem</td>" +
                "<td>1h sem celular</td>" +
                "<td>Treino abdominal</td>" +
                "<td>Dia livre/bonus</td>" +
                "</tr>" +
                "</table>";
    }

    private static String gerarRegrasMetaCardioCompacta() {
        return "<div class='regras-card-compacta'>" +
                "<h2>-> Instrucoes de Cardio</h2>" +
                "<ul>" +
                "<li>Escolha <b>1 tipo de cardio por dia</b> (caminhada, corrida, pular corda, etc.)</li>" +
                "<li>Tempo minimo: <b>20 a 30 minutos</b></li>" +
                "<li>Marque concluido apenas se completar o tempo</li>" +
                "</ul>" +
                "</div>";
    }

    private static String gerarTabelaMetaCardio(int diaInicio, int diaFim) {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>");
        sb.append("<tr>")
                .append("<th>Dia</th>")
                .append("<th>Tipo de Cardio</th>")
                .append("<th>Tempo (min)</th>")
                .append("<th>Concluido</th>")
                .append("</tr>");

        for (int i = diaInicio; i <= diaFim; i++) {
            sb.append("<tr>")
                    .append("<td class='dia-label'>").append(i).append("</td>")
                    .append("<td></td>")
                    .append("<td></td>")
                    .append("<td></td>")
                    .append("</tr>");
        }

        sb.append("</table>");
        return sb.toString();
    }
}