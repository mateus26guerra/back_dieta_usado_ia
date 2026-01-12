package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelMedioIaResponse;

import java.util.Map;

public class PdfMedioTemplate {

    public static String gerarHtml(
            PlanoNivelMedioIaResponse ia,
            String nomeUsuario,
            double metaAguaLitros,
            double metaAguaLitrosSemAtividadeFisica
    ) {

        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset='UTF-8'/>" +
                "<style>" +
                "body{font-family:Segoe UI,Arial,sans-serif;padding:40px;color:#1a1a1a;line-height:1.6}" +
                "h1{color:#1e40af;border-bottom:3px solid #3b82f6;padding-bottom:10px}" +
                "h2{color:#1e3a8a;margin-top:30px}" +
                "h3{color:#2563eb;margin-top:20px}" +
                ".card{background:#f8fafc;padding:24px;margin-bottom:20px;border-left:4px solid #3b82f6;border-radius:8px}" +
                ".destaque{background:#dbeafe;padding:16px;border-left:4px solid #2563eb;border-radius:6px;margin:16px 0}" +
                ".page-break{page-break-before:always}" +
                "table{width:100%;border-collapse:collapse;margin-top:20px}" +
                "th,td{border:1px solid #cbd5e1;padding:12px;text-align:center}" +
                "th{background:#1e40af;color:white}" +
                "</style>" +
                "</head>" +
                "<body>" +

                "<h1>Plano Nutricional Intermediário</h1>" +
                "<p><strong>Paciente:</strong> " + xmlSafe(nomeUsuario) + "</p>" +

                "<div class='card'>" +
                "<h2>Objetivo</h2>" +
                "<p>" + xmlSafe(ia.plano.objetivo) + "</p>" +
                "</div>" +

                "<div class='card'>" +
                "<h2>Descrição do Plano</h2>" +
                "<p>" + xmlSafe(ia.plano.descricao) + "</p>" +
                "</div>" +

                "<div class='card'>" +
                "<h2>Plano de Dieta</h2>" +
                "<p>" + xmlSafe(ia.conteudo.plano_de_dieta) + "</p>" +
                "</div>" +

                "<div class='page-break'></div>" +

                "<h1>Cardápio Semanal</h1>" +
                "<div class='card'>" +
                formatarCardapio5Dias(ia.conteudo.cardapio_5_dias) +
                "</div>" +

                "<div class='page-break'></div>" +

                "<h1>Atividade Física</h1>" +
                "<div class='card'>" +
                formatarAtividadeFisica(ia.conteudo.atividade_fisica) +
                "</div>" +

                "<h1>Orientações Gerais</h1>" +
                "<div class='card'>" +
                "<p>" + xmlSafe(ia.conteudo.orientacoes_gerais) + "</p>" +
                "</div>" +

                "<div class='page-break'></div>" +

                "<h1>Hidratação Diária</h1>" +

                "<div class='destaque'>" +
                "<p><strong>Como calculamos sua meta de água?</strong></p>" +
                "<p>• <strong>35 ml por kg de peso corporal</strong>: indicado para pessoas sem prática regular de atividade física.</p>" +
                "<p>• <strong>50 ml por kg de peso corporal</strong>: recomendado quando há prática de exercícios, maior gasto energético e perda de líquidos pelo suor.</p>" +
                "<p>Como este plano inclui <strong>atividade física</strong>, utilizamos a meta maior para garantir melhor hidratação, desempenho e recuperação muscular.</p>" +
                "</div>" +

                "<div class='card'>" +
                "<p><strong>Meta com atividade física:</strong> " + String.format("%.1f", metaAguaLitros) + " litros/dia</p>" +
                "<p><strong>Meta sem atividade física:</strong> " + String.format("%.1f", metaAguaLitrosSemAtividadeFisica) + " litros/dia</p>" +
                "</div>" +

                "<table>" +
                "<tr><th>Dia</th><th>Meta (L)</th><th>Consumido</th><th>Status</th></tr>" +
                gerarLinhasTabelaAgua(metaAguaLitros) +
                "</table>" +

                "</body></html>";
    }

    private static String formatarCardapio5Dias(
            Map<String, PlanoNivelMedioIaResponse.DiaCardapio> cardapio
    ) {
        if (cardapio == null || cardapio.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        cardapio.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    var d = entry.getValue();
                    sb.append("<h3>").append(xmlSafe(entry.getKey())).append("</h3><ul>")
                            .append("<li><strong>Café:</strong> ").append(xmlSafe(d.cafe)).append("</li>")
                            .append("<li><strong>Almoço:</strong> ").append(xmlSafe(d.almoco)).append("</li>")
                            .append("<li><strong>Lanche:</strong> ").append(xmlSafe(d.lanche)).append("</li>")
                            .append("<li><strong>Jantar:</strong> ").append(xmlSafe(d.jantar)).append("</li>")
                            .append("<li><strong>Ceia:</strong> ").append(xmlSafe(d.ceia)).append("</li>")
                            .append("</ul>");
                });
        return sb.toString();
    }

    private static String formatarAtividadeFisica(
            PlanoNivelMedioIaResponse.AtividadeFisica a
    ) {
        if (a == null) return "<p>Não informado</p>";

        return "<ul>" +
                "<li><strong>Musculação:</strong> " + xmlSafe(a.musculacao) + "</li>" +
                "<li><strong>Cardio:</strong> " + xmlSafe(a.cardio) + "</li>" +
                "<li><strong>Core:</strong> " + xmlSafe(a.core) + "</li>" +
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
}
