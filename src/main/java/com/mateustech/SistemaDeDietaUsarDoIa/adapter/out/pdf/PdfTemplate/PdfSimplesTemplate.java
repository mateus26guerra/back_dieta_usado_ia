package com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate;


import com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTextoPadrao;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelSimplesIaResponse;
public class PdfSimplesTemplate {

    public static String gerarHtml(PlanoNivelSimplesIaResponse ia) {

        String titulo = "Plano Básico";
        String subtitulo = "Solução simples e acessível para começar";


        String descricaoPlano = ia.plano != null && ia.plano.descricao != null
                ? ia.plano.descricao
                : "";

        return """
    <html>
    <head>
        <style>
            body { font-family: Arial; padding: 30px; }
            h1 { color: #2e7d32; }
            h2 { margin-top: 25px; }
            footer { font-size: 10px; margin-top: 40px; color: gray; }
            .usuario { font-size: 14px; color: #555; margin-bottom: 10px; }
            .descricao { font-size: 13px; color: #666; margin-bottom: 25px; }
        </style>
    </head>
    <body>

        <h1>%s</h1>
        <p><strong>%s</strong></p>

        <div class="descricao">
            %s
        </div>

        <div class="usuario">
            Plano gerado para: <strong>%s</strong>
        </div>

        <h2>Plano de Dieta</h2>
        <p>%s</p>

        <h2>Cardápio – 1 dia</h2>
        <p>%s</p>

        <h2>Orientações Gerais</h2>
        <p>%s</p>

        <footer>
            %s
        </footer>

    </body>
    </html>
    """.formatted(
                titulo,
                subtitulo,
                descricaoPlano,              // ✅ descrição aparece aqui
                ia.conteudo.plano_de_dieta_simples,
                ia.conteudo.cardapio_de_um_dia,
                ia.conteudo.orientacoes_gerais,
                PdfTextoPadrao.RODAPE
        );
    }


}
