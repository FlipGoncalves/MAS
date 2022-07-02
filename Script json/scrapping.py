import requests
from bs4 import BeautifulSoup
import json
from pathlib import Path
from random import randrange
#Cada função é uma loja, se quiserem
#por exemplo o json dos produtos da
#worten da secção telemóveis da samsung
#façam worten("https://www.worten.pt/telemoveis-e-pacotes-tv/telemoveis-e-smartphones/samsung") vendo o link no site deles
#USEM APENAS LINK DOS MENU QUE NÃO ESTÃO A NEGRITO
#as páginas dos menus a negrito nao tem a mesma formatação

#funcional para secção computadores ex:https://www.worten.pt/informatica-e-acessorios/computadores/computadores-portateis?per_page=48&page=1


def worten(url):
    curref = 1
    home = str(Path.home())
    URL = url
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, 'html.parser')
    print("Request com sucesso...")
    
    tipo = URL.split('/')[3]

    products = soup.find_all('div', class_='w-product')

    path = home+"/Desktop/products.json"  #Mudem o path do ficheiro para onde querem que o json seja exportado
    print(path)
    data = {}
    data[tipo] = []
    for product in products:

        titulo = product.find('h3',class_="w-product__title").text
        link = product.find('img')['data-src']
        imagem = "www.worten.pt" + link
        loja = "Worten"
        ref = "i_" + str(curref)
        curref += 1
        preco = product.find('span',class_="w-product-price__main").text
        nomeBeta = titulo.split("(")[0].split(" ")
        if "Pack" in nomeBeta:
            print("chupa caralho")
            continue
        if "enda" in nomeBeta[0]:
            nomeBeta.pop(0)
        nome = ""
        for string in nomeBeta:
            nome += string + " "
        especificacoes = titulo.split("(")[1].strip(")").split(" - ")
        gpu = ""
        memoria = ""
        ram = ""
        cpu = ""
        ecra = ""
        quantidade = str(randrange(10))
        for detalhes in especificacoes:
            if "UHD" in detalhes or "NVIDIA" in detalhes or "Iris" in detalhes or "Radeon" in detalhes:
                gpu = detalhes.strip(")")
            if "Core" in detalhes or "AMD" in detalhes or "Pentium" in detalhes or "Microsoft" in detalhes or "-" in detalhes:
                cpu = detalhes
            if "HDD" in detalhes or "SSD" in detalhes or "TB" :
                memoria = detalhes
            if "''" in detalhes :
                ecra = detalhes
            if "RAM" in detalhes :
                ram = detalhes
        if not gpu:
            gpu = "GPU Integrada"


        produto = {}
        produto[ref] = []
        produto[ref].append({
            'nome':nome,
            'referencia':ref,
            'imagem':imagem,
            'loja':loja,
            'preco':preco,
            'ram':ram,
            'gpu':gpu,
            'ecra':ecra,
            'cpu':cpu,
            'memoria':memoria,
            'quantidade': quantidade
        })

        data[tipo].append(produto)
            

    with open(path,'w') as outfile:
        json.dump(data, outfile)

#funcional para telemoveis
def worten2(url):
    curref = 50
    home = str(Path.home())
    URL = url
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, 'html.parser')
    print("Request com sucesso...")
    
    tipo = URL.split('/')[4]

    products = soup.find_all('div', class_='w-product')

    path = home+"/Desktop/products.json"  #Mudem o path do ficheiro para onde querem que o json seja exportado
    print(path)
    data = {}
    data[tipo] = []
    ref = 1
    for product in products:

        titulo = product.find('h3',class_="w-product__title").text
        link = product.find('img')['data-src']
        imagem = "www.worten.pt" + link
        loja = "Worten"
        ref = "t_" + str(curref)
        preco = product.find('span',class_="w-product-price__main").text
        nomeBeta = titulo.split('(',1)[0]

        try:
            details = titulo.split('(',1)[1]
        except IndexError:
            continue

        details = details.replace(')','').replace(' ','').split('-')

        if(len(details) != 4):
            continue

        curref += 1
        ecra = details[0]
        ram = details[1]
        memoria = details[2]
        cor = details[3]
        quantidade = str(randrange(10))

        produto = {}
        produto[ref] = []
      
        produto[ref].append({
            'nome':nomeBeta,
            'referencia':ref,
            'imagem':imagem,
            'loja':loja,
            'preco':preco,
            'ram':ram,
            'ecra':ecra,
            'memoria':memoria,
            'quantidade': quantidade
        })

        data[tipo].append(produto)
            

    with open(path,'a') as outfile:
        json.dump(data, outfile)
    print(curref)

#Funcional para sapatilhas (a src das imagens sao protegidas nestes requests :()
def sportzone(url):
    curref = 90
    home = (str)(Path.home())
    URL = url
    page = requests.get(URL)
    soup = BeautifulSoup(page.content, 'html.parser')
    print("Request com sucesso...")

    tipo = URL.split('/')[4]
    print(tipo)

    products = soup.find_all('div', class_='product-card')

    path = home + "/Desktop/products.json"
    data = {}
    data[tipo] = []

    for product in products:
        nome = product.find('a', class_="product-card__info-name").text
        imagem = product.find('img', class_='v-lazy-image')['src']
        print(imagem)
        loja = "SportZone"
        ref = "c_" + str(curref)
        curref += 1
        preco = product.find('span', class_="product-card__info-price-actual").text

        #A partir daqui sao as caracteristicas das sapatilhas
        tamanhos = []

        #Gerador tamanhos random
        randomTamanhos = [36,37,38,39,40,41]
        indexes = [randrange(6),randrange(6),randrange(6),randrange(6),randrange(6)]

        i = 0
        while i < 5:
            for index in indexes:
                if randomTamanhos[index] not in tamanhos:
                    tamanhos.append(randomTamanhos[index])
            i+=1

        tamanhos.sort()

        produto = {}
        produto[ref] = []
        
        produto[ref].append({
            'nome':nome,
            'referencia':ref,
            'imagem':imagem,
            'loja':loja,
            'preco':preco,
            'tamanhos':tamanhos
        })

        data[tipo].append(produto)
    with open(path,'a') as outfile:
        json.dump(data, outfile)

worten('https://www.worten.pt/informatica-e-acessorios/computadores/computadores-portateis?per_page=48&page=1')
worten2('https://www.worten.pt/telemoveis-e-pacotes-tv/telemoveis-e-smartphones/samsung?per_page=48&page=2')
sportzone('https://www.sprintersports.com/pt/sapatilhas-casual-homem')
