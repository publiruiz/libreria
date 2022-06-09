package com.libreria.libreria.persistencia.entity;

public enum TypeEnum {
        Accion_aventura,
        Arte_cine_fotografia,
        Biografias_memorias,
        Ciencia_ficcion,
        fantasia_terror,
        Ciencias,
        Tecnologia_Medicina,
        Comics_Manga,
        Deportes,
        Derecho_Economia_Empresa,
        Erotica,
        Ficcion_historica,
        Historia,
        Hogar,
        Manualidades_Estilos_De_Vida,
        Humor,
        Infantil,
        Informatica_Internet,
        Juvenil,
        Lengua,
        Libros_de_Texto,
        Literatura_Ficcion,
        Policiaca,
        Novela_Negra,
        Politica,
        Religion,
        Romantica,
        Salud,
        Sociedad,
        Viajes;

        private String type;

        private void PropType(String type) {
                this.type = type;
        }

        public String getType() {
                return type;
        }

        public static TypeEnum getByType(String type){
                return  TypeEnum.valueOf(type) ;
        }
}
