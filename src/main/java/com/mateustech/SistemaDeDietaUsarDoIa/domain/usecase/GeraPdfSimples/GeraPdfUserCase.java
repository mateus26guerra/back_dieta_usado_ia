package com.mateustech.SistemaDeDietaUsarDoIa.domain.usecase.GeraPdfSimples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate.PdfCompletoTemplate;
import com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate.PdfMedioTemplate;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.contracts.IaGateway;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.contracts.PdfGateway;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaCompleto;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaMedio;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.FormularioDietaSimple;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.FormularioDieta.Usuario.Uenum.Sexo;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelCompletoIaResponse;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelMedioIaResponse;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.model.PlanoNivelSimplesIaResponse;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.prompt.PromptNivelCompleto;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.prompt.PromptNivelMedio;
import com.mateustech.SistemaDeDietaUsarDoIa.domain.model.IA.prompt.PromptNivelSimples;
import com.mateustech.SistemaDeDietaUsarDoIa.adapter.out.pdf.PdfTemplate.PdfSimplesTemplate;
import org.springframework.stereotype.Service;

@Service
public class GeraPdfUserCase {


    private final IaGateway iaGateway;
    private final PdfGateway pdfGateway;
    private final ObjectMapper objectMapper;

    public GeraPdfUserCase(IaGateway iaGateway, PdfGateway pdfGateway) {
        this.iaGateway = iaGateway;
        this.pdfGateway = pdfGateway;
        this.objectMapper = new ObjectMapper();
    }
    public byte[] gerarPdfSimples(FormularioDietaSimple formulario) {
        try {
            String formularioJson = objectMapper.writeValueAsString(formulario);

            String prompt = PromptNivelSimples.gerar(formularioJson);

            String respostaIaJson = iaGateway.gerarPlanoJson(prompt);

            PlanoNivelSimplesIaResponse iaResponse =
                    objectMapper.readValue(respostaIaJson, PlanoNivelSimplesIaResponse.class);

            String nomeUsuario = formulario.getUsuario() != null
                    ? formulario.getUsuario().getPrimeiro_nome()
                    : "Usuário";

            String html = PdfSimplesTemplate.gerarHtml(
                    iaResponse,
                    nomeUsuario
            );

            return pdfGateway.gerar(html);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF simples", e);
        }
    }



    public byte[] gerarPdfMedio(FormularioDietaMedio formulario) {
        try {
            String formularioJson = objectMapper.writeValueAsString(formulario);

            String prompt = PromptNivelMedio.gerar(formularioJson);

            String respostaIaJson = iaGateway.gerarPlanoJson(prompt);

            PlanoNivelMedioIaResponse iaResponse =
                    objectMapper.readValue(respostaIaJson, PlanoNivelMedioIaResponse.class);

            String nomeUsuario = formulario.getUsuario() != null
                    ? formulario.getUsuario().getPrimeiro_nome()
                    : "Usuário";

            double peso = formulario.getDadosFisicos().getPesoAtual();
            double metaAguaLitros = peso * 0.05; // 50ml por kg

            double metaAguaLitrosSemAtividadeFisica = peso * 0.035; // 50ml por kg

            String html = PdfMedioTemplate.gerarHtml(
                    iaResponse,
                    nomeUsuario,
                    metaAguaLitros,
                    metaAguaLitrosSemAtividadeFisica
            );

            return pdfGateway.gerar(html);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF intermediário", e);
        }
    }



    public byte[] gerarPdfCompleto(FormularioDietaCompleto formulario) {
        try {
            String formularioJson = objectMapper.writeValueAsString(formulario);

            String prompt = PromptNivelCompleto.gerar(formularioJson);

            String respostaIaJson = iaGateway.gerarPlanoJson(prompt);

            PlanoNivelCompletoIaResponse iaResponse =
                    objectMapper.readValue(respostaIaJson, PlanoNivelCompletoIaResponse.class);

            String nomeUsuario = formulario.getUsuario() != null
                    ? formulario.getUsuario().getPrimeiro_nome()
                    : "Usuário";

            double idade = formulario.getUsuario() != null
                    ? formulario.getUsuario().getIdade()
                    : 0;

            Sexo sexo = formulario.getUsuario() != null
                    ? formulario.getUsuario().getSexo():
                    Sexo.Prefiro_nao_dizer;


            double peso = formulario.getDadosFisicos().getPesoAtual();
            double metaAguaLitros = peso * 0.05; // 50ml por kg

            double metaAguaLitrosSemAtividadeFisica = peso * 0.035; // 50ml por kg

            String html = PdfCompletoTemplate.gerarHtml(
                    iaResponse,
                    nomeUsuario,
                    idade,
                    sexo,
                    metaAguaLitros,
                    metaAguaLitrosSemAtividadeFisica
            );

            return pdfGateway.gerar(html);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF completo", e);
        }
    }

}
