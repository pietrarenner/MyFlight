import java.time.Duration;
import java.time.LocalDateTime;

public class App 
{
    public static void main(String[] args) 
    {
        Aeronave aviao = new Aeronave("codigo", "descricao");

        CiaAerea companhia = new CiaAerea("codigocia", "nomecia");
        Geo local = new Geo(123, 456);
        Geo local1 = new Geo(557, 390);
        Aeroporto Congonhas = new Aeroporto("CON", "concon", local1);
        Aeroporto salgadoFilho = new Aeroporto("salgadinho", "nomeSalga", local);

        Rota rota = new Rota(companhia, salgadoFilho, Congonhas, aviao);

        //teste primeiro construtor da classe Voo
        //Voo voo = new Voo(rota, LocalDateTime.of(2022, 12, 5, 10, 20, 50), Duration.ofHours(2));

        //teste segundo construtor da classe Voo
        //Voo voo1 = new Voo(rota, Duration.ofHours(3));

        //teste método static distância da classe Geo
        Geo outrolocal = new Geo(567, 425);
        double distancia1 = Geo.distancia(local, outrolocal);

        //teste método não static distância da classe Geo
        double distancia2 = local.distancia(outrolocal);

        //teste interface CompareTo Aeroporto
        Aeroporto Guarulhos = new Aeroporto("GRU", "guagua", outrolocal);
        Guarulhos.compareTo(salgadoFilho);

        //teste interface CompareTo Rota
        Rota rota1 = new Rota(companhia, Guarulhos, Congonhas, aviao);
        rota1.compareTo(rota);

        //teste interface Contavel Aeronave
        Aeronave aviao2 = new Aeronave("1234", "azul");
        aviao2.contar();

        //teste VooEscalas
        //VooEscalas vooEscalas = new VooEscalas(rota, rota1, LocalDateTime.of(2022, 9, 9, 18, 24, 6), Duration.ofHours(1));

        //teste VooVariasEscalas
        Rota rota2 = new Rota(companhia, Congonhas, salgadoFilho, aviao2);
        //VooVariasEscalas voo2 = new VooVariasEscalas(rota, LocalDateTime.of(2022, 8, 15, 2, 40, 45), Duration.ofMinutes(40));
        // voo2.inserirEscala(rota1);
        // voo2.inserirEscala(rota2);

        //teste OrdenaNome GerenciadorAeroportos - Nao quero.
        // GerenciadorAeroportos.ordenaNome();

        //testes que precisamos fazer:
        //arrumar voo - FEITO
        //arrumar teste segundo construtor voo - FEITO

        //calcular distância classe geo - static e não static - FEITO 
        //testar CompareTo Aeroporto - FEITO
        //testar CompareTo Rota - FEITO

        //testar método ordenaNome em GerenciadorAeroportos
        //testar método ordenaNome em GerenciadorRotas

        //testar interface contavel aeronave - FEITO

        //testar VooVariasEscalas - FEITO
        //fazer toString em VooVariasEscalas - FEITO
        //testar VooEscalas - FEITO

        // System.out.println(voo2.toString());

        // System.out.println(vooEscalas.toString());

        //TESTANDO VOO NOVO
        VooDireto vood = new VooDireto(LocalDateTime.of(2022, 12, 5, 10, 20, 50), rota);
        System.out.println(vood.toString());

        VooEscalas vooe = new VooEscalas(LocalDateTime.of(2022, 12, 5, 10, 20, 50));
        vooe.adicionaRota(rota1);
        vooe.adicionaRota(rota2);
        System.out.println(vooe.toString());

    }
    
}
