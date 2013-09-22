/*
 * url-shortener.c
 *
 *  Created on: Sep 17, 2013
 *      Authors: César Alberto Trejo Juárez, Magnus Henkel.
 */


#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
#include<time.h>

struct url{
	char *url_long;
	char *url_short;
	struct url *next;
	struct url *previous;
};

/* -------------------------------- */
/* Function declaration             */
/* -------------------------------- */
struct url *initList();
char menu();
void exec(char answ);
char* concat(char *string1, char *string2);
void loader(struct url *list);
char *urlShortener(char *input_string);
int searchLongUrl(char *long_url, struct url *list);
void searchShortUrl(char *long_url, struct url *list);
void eraseURL(struct url *list, char *name);
void showList(struct url *list);
void write2File(struct url *list);

/* -------------------------------- */
/* Global declaration               */
/* -------------------------------- */

struct url *list;
int menu_resp;
int in_err;

/* -------------------------------- */
/* Function main                    */
/* -------------------------------- */

int main(int argc, const char * argv[])
{
    list = initList(); //inicializando la lista
    loader(list);

    printf("\t\t\tWelcome!\nPlease select one of the following options:");

    do {
        menu_resp=menu();// Ejecutamos Menu
        exec(menu_resp); // Ejecutamos switch
        if(in_err == 3) {
            printf("Aborting... too many failed attempts");
            break;
        }

    } while (menu_resp!=5);

    printf("Exiting\n");
}
// #################################################################################
/* End of main */

/* -------------------------------- */
/* Function initList                */
/* -------------------------------- */
struct url *initList() {
    struct url *temp;
    temp = (struct url *)malloc(sizeof(struct url));
    temp->next = NULL;
    temp->previous = NULL;
    return temp;
}

/* -------------------------------- */
/* Function loader                  */
/* -------------------------------- */
void loader(struct url *lists) {
	FILE *datafile;
	datafile = fopen("urls.txt", "r");  //GERMAN cambia la ruta para que lo puedas ejecutar
    char *string_cut = NULL;
    string_cut = (char *)malloc(sizeof(string_cut));
    char *larga = NULL;
    larga = (char *)malloc(sizeof(larga));
    char *corta = NULL;
    corta = (char *)malloc(sizeof(corta));

    struct url *temp;
    char whole_string[800];


	while(!feof(datafile)) {

        temp = initList();
		fscanf(datafile, "%s\n", whole_string);
        string_cut = strdup(whole_string);

        temp->url_long = strsep(&string_cut, ",");
        temp->url_short= strsep(&string_cut, ",");

        // INSERTA EN LISTA...
        temp->previous = list;
        temp->next = list->next;
        list->next = temp;
    }
	fclose(datafile);
}

/* -------------------------------- */
/* Function menu                    */
/* -------------------------------- */
char menu() {
    char answ[1];
    //int in_err = 0;

    printf("\n\n\t1. Insert URL");
    printf("\n\t2. Search");
    printf("\n\t3. Erase");
    printf("\n\t4. List all");
    printf("\n\t5. Exit and save");
    printf("\n\nOption: ");
    scanf("%s", answ);

    return atoi(answ);
}

/* -------------------------------- */
/* Function exec(switch)            */
/* -------------------------------- */

void exec(char answer) {

    char url_long_str[500], url_short_str[200];
    char yesno;

    switch(answer) {

        case 1:
            do{
                struct url *new_url;

                printf("Please paste your URL: ");
                fflush(stdin);
                getchar();
                scanf("%s", url_long_str);

                char *url_long_ptr = NULL;
                url_long_ptr = (char *)malloc(sizeof(url_long_str + 200));
                url_long_ptr = strdup(url_long_str);

                if(searchLongUrl(url_long_ptr, list) == 1) {
                    new_url = initList();
                    new_url->url_long = url_long_ptr;
                    new_url->url_short = urlShortener(url_long_ptr);
                    printf("Inserting new URL...\n");
                    // INSERTA new_url a la lista
                    new_url->previous = list;
                    new_url->next = list->next;
                    list->next = new_url;
                    printf("Your short url is: %s", new_url->url_short);
                } else {
                    printf("\nURL found in database. No action taken.\n");
                }
                // termina busqueda y/o codificacion
                printf("\nInsert another URL? (y/n)\n");
                scanf("%s",&yesno);
                yesno=tolower(yesno);// cambia mayusculas a minusculas
            } while(yesno=='y');
            break;

        case 2:
            do{
                printf("Paste short URL: ");

                fflush(stdin);
                getchar();

                scanf("%s", url_short_str);

                printf("Searching...\n");

                char *url_short_ptr = NULL;
                url_short_ptr = (char *)malloc(sizeof(url_short_str + 200));
                url_short_ptr = url_short_str;

                searchShortUrl(url_short_ptr, list);

                printf("\nSearch another URL? (y/n)\n");
                scanf("%s",&yesno);
                yesno=tolower(yesno);// cambia mayusculas a minusculas

            }while(yesno=='y');
            break;
        case 3:
            do{
            	char dlname[100];
            	strcpy(dlname, "");
            	char *toerase = NULL;
            	toerase = (char *)malloc(sizeof(500));

            	getchar();
                printf("Paste short URL:");
                scanf("%s", dlname);
                toerase = strdup(dlname);

                eraseURL(list, toerase);

                printf("\nErase another URL? (y/n)\n");
                scanf("%s",&yesno);
                yesno=tolower(yesno);// cambia mayusculas a minusculas

            }while(yesno=='y');
            break;
        case 4:
            printf("Listing all...\n\n");

            showList(list);

            break;
        case 5:
            printf("Writing to file...\n");

            write2File(list);

            printf("\n\nGood-bye!");
            exit(1);
        default:
            in_err ++;
            printf("Input error");
    }
}

/* -------------------------------- */
/* Function url_shortener           */
/* -------------------------------- */
char *urlShortener(char *input_string) {

    char digits[36]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int j, i, k=0, quotient, remainder;
    int total_digits=0, number;
    int c=0;
    char result[100];
    char temp;
    char *concat_string;

    //sumamos el valor ascii de cada elemento del url largo para convertirlo a base 36

    srand(time(NULL));
    int randomnumber = rand() % 1000; // randomizando la url corta que sirve como ID también

    for (j=0; input_string[j]!='\0'; j++)
        c += (toascii(input_string[j]) + randomnumber);
    number = c;
    while(number >= 36){
        remainder = number % 36;
        quotient = number / 36;

        number = quotient;

        result[k]=digits[remainder];

        k++;
    }

    //Guardamos el ultimo cociente de la ultima division o bien si no paso por el ciclo while, pues el numero si es menor que 35
    result[k] = digits[number];

    concat_string = strdup("http://un.am/");

    for(i = 0,total_digits = k; i<=k; i++,total_digits--){
        temp=result[total_digits];
        result[total_digits]=result[i];
        result[i]=temp;
    }
    strcat(concat_string, result);
    return concat_string;
}

/* -------------------------------- */
/* Function write2File              */
/* -------------------------------- */
void write2File(struct url *list) {

	FILE *datafile;
	datafile = fopen("urls.txt","w");
	struct url *temp;

	temp = list;

	while (temp != NULL) {
		if(temp->url_long != NULL)
			fprintf(datafile, "%s,%s\n", temp->url_long, temp->url_short);
		temp = temp->next;
	}


	fclose(datafile);
}

/* -------------------------------- */
/* Function searchLongUrl           */
/* -------------------------------- */
int searchLongUrl(char *long_url, struct url *list) {
    struct url *temp;
	int found = 1; // no encuentra

    temp = list->next;

    while(temp != NULL) {
		if(strcmp(long_url, temp->url_long) == 0) { // encontramos la url larga
			found = 0;
            printf("Your short url is: %s", temp->url_short);
		}
        temp = temp->next;

	}
    return found;
}

/* -------------------------------- */
/* Function searchByShortUrl        */
/* -------------------------------- */
void searchShortUrl(char *short_url, struct url *list) {
    struct url *temp;
	int found = 1; //no encuentra
    temp = list->next;

    while(temp != NULL) {
		if(strcmp(short_url, temp->url_short) == 0) { // encontramos la url larga
			found = 0;
			printf("URL found!\n");
			printf("Long URL found: %s\n", temp->url_long);
            break;
		}

        temp = temp->next;
	}

    if (found == 1) {
        printf("Short URL is not in database.\n");
    }
}

/* -------------------------------- */
/* Function eraseByShortUrl         */
/* -------------------------------- */
void eraseURL(struct url *list, char *name){
    struct url *temp;

    temp = list;
    while (temp->next != NULL) {
        //printf("\n%s->%s", (temp->next)->url_short, name); //DEBUGGING

        if (strcmp((temp->next)->url_short, name) == 0) {
            temp->next = (temp->next)->next;
            //printf(">>>%s", temp->url_long); //DEBUGGING
        }

        temp = temp->next;
    }
}

/* -------------------------------- */
/* Function showList                */
/* -------------------------------- */
void showList(struct url *list){
    struct url *temp;

    temp = list->next;

  	printf("\nShort URL\t\t\t\t\tLong URL\n");

    while (temp != NULL) {
        printf("%s\t\t%s\n", temp->url_short, temp->url_long);
        temp = temp->next;
    }
}

/* -------------------------------- */
/* Function concat                  */
/* -------------------------------- */
char* concat(char *string1, char *string2) {

    char *result = malloc(strlen(string1)+strlen(string2)+8);
    strcpy(result, "\n");
    strcat(result, string1);
    strcat(result, ",");
    strcat(result, string2);
    return result;
}
