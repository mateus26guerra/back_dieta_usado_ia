package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate;

import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelMedioIaResponse;

import java.util.Map;

public class PdfMedioTemplate {

    public static String gerarHtml(
            PlanoNivelMedioIaResponse ia,
            String nomeUsuario,
            double metaAguaLitros
    ) {

        return """
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<style>
body {
    font-family: "Noto Sans", Arial, sans-serif;
    background: #f8fafc;
    padding: 32px;
    color: #0f172a;
}

h1 {
    color: #1e40af;
    margin-bottom: 8px;
}

h2, h3 {
    color: #1e3a8a;
    margin-bottom: 10px;
}

.card {
    background: #ffffff;
    padding: 22px;
    margin-bottom: 20px;
    border-radius: 12px;
    border: 1px solid #e5e7eb;
}

.section-title {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 12px;
}

.page-break {
    page-break-before: always;
}

/* Cardápio */
ul {
    margin: 0;
    padding-left: 18px;
}

li {
    margin-bottom: 6px;
}

/* Tabela de água */
table {
    width: 100%%;
    border-collapse: collapse;
    margin-top: 16px;
}

th, td {
    border: 1px solid #c7d2fe;
    padding: 10px;
    text-align: center;
}

th {
    background: #e0e7ff;
    font-weight: bold;
}
</style>
</head>

<body>

<h1>Plano Nutricional Intermediário</h1>
<p><strong>Paciente:</strong> %s</p>

<div class="card">
    <div class="section-title">Objetivo</div>
    <p>%s</p>
</div>

<div class="card">
    <div class="section-title">Descrição do Plano</div>
    <p>%s</p>
</div>

<div class="card">
    <div class="section-title">Plano de Dieta</div>
    <p>%s</p>
</div>

<div class="card">
    <div class="section-title">Cardápio (5 dias)</div>
    %s
</div>

<div class="card">
    <div class="section-title">Atividade Física</div>
    %s
</div>

<div class="card">
    <div class="section-title">Orientações Gerais</div>
    <p>%s</p>
</div>

<div class="page-break"></div>

<h1>Controle Mensal de Hidratação</h1>
<p><strong>Meta diária:</strong> %.1f litros</p>

<table>
<tr>
    <th>Dia</th>
    <th>Meta (L)</th>
    <th>Consumido</th>
    <th>Status</th>
</tr>
%s
</table>

</body>
</html>
""".formatted(
                xmlSafe(nomeUsuario),
                xmlSafe(ia.plano.objetivo),
                xmlSafe(ia.plano.descricao),
                xmlSafe(ia.conteudo.plano_de_dieta),
                formatarCardapio5Dias(ia.conteudo.cardapio_5_dias),
                formatarAtividadeFisica(ia.conteudo.atividade_fisica),
                xmlSafe(ia.conteudo.orientacoes_gerais),
                metaAguaLitros,
                gerarLinhasTabelaAgua(metaAguaLitros)
        );
    }

    /* =========================
       CARDÁPIO ORGANIZADO
       ========================= */
    private static String formatarCardapio5Dias(
            Map<String, PlanoNivelMedioIaResponse.DiaCardapio> cardapio
    ) {
        if (cardapio == null || cardapio.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();

        cardapio.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // Dia 1 → Dia 5
                .forEach(entry -> {
                    PlanoNivelMedioIaResponse.DiaCardapio dia = entry.getValue();

                    sb.append("""
                    <div style="margin-bottom:16px;">
                        <h3>%s</h3>
                        <ul>
                            <li><strong>Café:</strong> %s</li>
                            <li><strong>Almoço:</strong> %s</li>
                            <li><strong>Lanche:</strong> %s</li>
                            <li><strong>Jantar:</strong> %s</li>
                            <li><strong>Ceia:</strong> %s</li>
                        </ul>
                    </div>
                    """.formatted(
                            xmlSafe(entry.getKey()),
                            xmlSafe(dia.cafe),
                            xmlSafe(dia.almoco),
                            xmlSafe(dia.lanche),
                            xmlSafe(dia.jantar),
                            xmlSafe(dia.ceia)
                    ));
                });

        return sb.toString();
    }

    /* =========================
       ATIVIDADE FÍSICA
       ========================= */
    private static String formatarAtividadeFisica(
            PlanoNivelMedioIaResponse.AtividadeFisica atividade
    ) {
        if (atividade == null) return "";

        return """
        <ul>
            <li><strong>Musculação:</strong> %s</li>
            <li><strong>Cardio:</strong> %s</li>
            <li><strong>Core:</strong> %s</li>
        </ul>
        """.formatted(
                xmlSafe(atividade.musculacao),
                xmlSafe(atividade.cardio),
                xmlSafe(atividade.core)
        );
    }

    /* =========================
       TABELA DE ÁGUA
       ========================= */
    private static String gerarLinhasTabelaAgua(double meta) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 31; i++) {
            sb.append("""
            <tr>
                <td>%d</td>
                <td>%.1f</td>
                <td></td>
                <td></td>
            </tr>
            """.formatted(i, meta));
        }
        return sb.toString();
    }

    /* =========================
       SEGURANÇA XML
       ========================= */
    private static String xmlSafe(String text) {
        if (text == null) return "";
        return text
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
