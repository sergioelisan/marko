package br.senai.validacao;

/**
 *
 * @author Serginho
 */
public interface Especificacao<T> {
    
    boolean isValidado(T u);
    
}
