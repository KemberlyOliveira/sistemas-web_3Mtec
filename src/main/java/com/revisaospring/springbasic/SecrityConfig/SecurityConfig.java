package com.revisaospring.springbasic.SecrityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.revisaospring.springbasic.Service.CustomUserDetailService;

// Define que esta classe é uma classe de configuração do Spring
@Configuration
public class SecurityConfig {

    // Injeção das dependências de serviço de usuário e codificador de senha
    private final CustomUserDetailService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    // Construtor para injeção de dependência das propriedades acima
    public SecurityConfig(CustomUserDetailService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    // Bean principal que define a cadeia de filtros de segurança da aplicação
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // Tratamento de exceção obrigatório do Spring Security
        http
            // Chama as funções que fazem a filtragem de quem pode acessar o quê
            .authorizeHttpRequests(auth -> auth
                // Define as regras de permissão para os caminhos de URL abaixo
                .requestMatchers( 
                    "/usuarioCTR/formCadastrarUsuario", // Passa o mesmo endereço mapeado na Controller
                    "/usuarioCTR/login",
                    "/usuarioCTR/salvarUsuario",
                    "/usuarioCTR/listarUsuarios",
                    "/produtoCTR/**" // O '**' significa que vai liberar acesso para tudo que vier depois dessa rota
                ).permitAll() // Permite o acesso público (sem autenticação) para as rotas listadas acima
                .anyRequest().authenticated() // Qualquer outra requisição além das listadas precisa estar autenticada
            )
            // Configuração do formulário de login personalizado da aplicação
            .formLogin(form -> form 
                .loginPage("/usuarioCTR/login") // Caminho/URL da página de login customizada
                .loginProcessingUrl("/login") // URL que processa o login (deve ser a mesma do th:action="@{/login}" no HTML)
                .defaultSuccessUrl("/usuarioCTR/listarUsuarios", true) // Define para qual página o usuário será direcionado após o sucesso no login
                .permitAll() // Permite acesso público à página de login
            )
            // Vincula o serviço customizado de busca de usuários ao Spring Security
            .userDetailsService(userDetailsService)
            
            // Desabilita a proteção CSRF. Útil para testes, pois se ativa, exige configurações adicionais nas requisições/controllers
            .csrf(csrf -> csrf.disable()); 
                            
        // Constrói e retorna o objeto SecurityFilterChain configurado
        return http.build();
    }

}



///     http://localhost:8080/usuarioCTR/formCadastrarUsuario