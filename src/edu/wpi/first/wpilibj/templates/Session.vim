let SessionLoad = 1
if &cp | set nocp | endif
let s:cpo_save=&cpo
set cpo&vim
inoremap <Plug>ZenCodingAnchorizeSummary :call zencoding#anchorizeURL(1)a
inoremap <Plug>ZenCodingAnchorizeURL :call zencoding#anchorizeURL(0)a
inoremap <Plug>ZenCodingRemoveTag :call zencoding#removeTag()a
inoremap <Plug>ZenCodingSplitJoinTagInsert :call zencoding#splitJoinTag()
inoremap <Plug>ZenCodingToggleComment :call zencoding#toggleComment()a
inoremap <Plug>ZenCodingImageSize :call zencoding#imageSize()a
inoremap <Plug>ZenCodingPrev :call zencoding#moveNextPrev(1)
inoremap <Plug>ZenCodingNext :call zencoding#moveNextPrev(0)
inoremap <Plug>ZenCodingBalanceTagOutwardInsert :call zencoding#balanceTag(-1)
inoremap <Plug>ZenCodingBalanceTagInwardInsert :call zencoding#balanceTag(1)
inoremap <Plug>ZenCodingExpandWord u:call zencoding#expandAbbr(1,"")a
inoremap <Plug>ZenCodingExpandAbbr u:call zencoding#expandAbbr(0,"")a
inoremap <silent> <S-Tab> =BackwardsSnippet()
inoremap <C-Tab> 	
vmap  <Plug>VisualIncrement
nmap  <Plug>SpeedDatingUp
vnoremap <silent>  :call RangeCommentLine()
nnoremap <silent>  :call CommentLine()
onoremap <silent>  :call CommentLine()
nnoremap  :noh 
snoremap <silent> 	 i<Right>=TriggerSnippet()
nnoremap <NL> okk
nnoremap  O
map  :tabnew
map  :wa
snoremap  b<BS>
xmap  <Plug>VisualDecrement
nmap  <Plug>SpeedDatingDown
vmap c <Plug>ZenCodingCodePretty
nmap A <Plug>ZenCodingAnchorizeSummary
nmap a <Plug>ZenCodingAnchorizeURL
nmap k <Plug>ZenCodingRemoveTag
nmap j <Plug>ZenCodingSplitJoinTagNormal
vmap m <Plug>ZenCodingMergeLines
nmap / <Plug>ZenCodingToggleComment
nmap i <Plug>ZenCodingImageSize
nmap N <Plug>ZenCodingPrev
nmap n <Plug>ZenCodingNext
vmap D <Plug>ZenCodingBalanceTagOutwardVisual
nmap D <Plug>ZenCodingBalanceTagOutwardNormal
vmap d <Plug>ZenCodingBalanceTagInwardVisual
nmap d <Plug>ZenCodingBalanceTagInwardNormal
nmap , <Plug>ZenCodingExpandNormal
vmap , <Plug>ZenCodingExpandVisual
noremap s :TCommentAs =&ft_
noremap n :TCommentAs =&ft 
noremap a :TCommentAs 
noremap b :TCommentBlock
vnoremap <silent> r :TCommentRight
vnoremap <silent> i :TCommentInline
nnoremap <silent> r :TCommentRight
onoremap <silent> r :TCommentRight
noremap   :TComment 
noremap <silent> p m`vip:TComment``
vnoremap <silent>  :TCommentMaybeInline
nnoremap <silent>  :TComment
onoremap <silent>  :TComment
snoremap % b<BS>%
snoremap ' b<BS>'
nnoremap ' `
map + +
nnoremap <silent> ,b :CommandTBuffer
nmap <silent> ,lg :LustyBufferGrep
nmap <silent> ,lb :LustyBufferExplorer
nmap <silent> ,lr :LustyFilesystemExplorerFromHere
nmap <silent> ,lf :LustyFilesystemExplorer
nmap ,ihn :IHN
nmap ,is :IHS:A
nmap ,ih :IHS
noremap ,_s :TCommentAs =&ft_
noremap ,_n :TCommentAs =&ft 
noremap ,_a :TCommentAs 
noremap ,_b :TCommentBlock
xnoremap <silent> ,_r :TCommentRight
nnoremap <silent> ,_r :TCommentRight
snoremap <silent> ,_r :TCommentRight
onoremap <silent> ,_r :TCommentRight
xnoremap <silent> ,_i :TCommentInline
noremap ,_  :TComment 
noremap <silent> ,_p vip:TComment
xnoremap <silent> ,__ :TCommentMaybeInline
nnoremap <silent> ,__ :TComment
snoremap <silent> ,__ :TComment
onoremap <silent> ,__ :TComment
nmap ,se :Errors
nmap ,v :vsplit
map ,r :NERDTreeToggle
map ,m :call MakeAndRun()
nmap ,sv :so $HOME/.vimrc
nmap <silent> ,ev :e $HOME/.vimrc
map ,n :set invnumber " toggles line number
nmap ,q :q
map ,t :CommandT
map ,co mzggVG"*y'z
nmap ,a: :Tabularize /:\zs
nmap ,a[ :Tabularize /{
nmap ,a= :Tabularize /=
nmap ,mp :MarkdownPreview
map - -
nmap ; :
xmap S <Plug>VSurround
snoremap U b<BS>U
vmap [% [%m'gv``
snoremap \ b<BS>\
map \c :echo g:colors_name
map \p :CP
map \n :CN
vmap ]% ]%m'gv``
snoremap ^ b<BS>^
snoremap ` b<BS>`
nnoremap ` '
vmap a% [%v]%
nmap cs <Plug>Csurround
nmap cr <Plug>Coerce
nmap ds <Plug>Dsurround
nmap d <Plug>SpeedDatingNowLocal
nmap d <Plug>SpeedDatingNowUTC
nmap gx <Plug>NetrwBrowseX
xmap gS <Plug>VgSurround
xnoremap <silent> gC :TCommentMaybeInline
nnoremap <silent> gCc :let w:tcommentPos = getpos(".") | set opfunc=tcomment#OperatorLineAnywayg@$
nnoremap <silent> gC :let w:tcommentPos = getpos(".") | set opfunc=tcomment#OperatorAnywayg@
xnoremap <silent> gc :TCommentMaybeInline
nnoremap <silent> gcc :let w:tcommentPos = getpos(".") | set opfunc=tcomment#OperatorLineg@$
nnoremap <silent> gc :let w:tcommentPos = getpos(".") | set opfunc=tcomment#Operatorg@
noremap ggd :Gdiff
noremap ggl :Glog
noremap gga :Gwrite
noremap ggc :Gcommit
noremap ggs :Gstatus
map gf :e <cfile>
xnoremap <silent> s :echoerr 'surround.vim: Visual mode s has been removed in favor of S'
nmap ySS <Plug>YSsurround
nmap ySs <Plug>YSsurround
nmap yss <Plug>Yssurround
nmap yS <Plug>YSurround
nmap ys <Plug>Ysurround
snoremap <Left> bi
snoremap <Right> a
snoremap <BS> b<BS>
snoremap <silent> <S-Tab> i<Right>=BackwardsSnippet()
nnoremap <silent> <Plug>NetrwBrowseX :call netrw#NetrwBrowseX(expand("<cWORD>"),0)
vnoremap <Plug>ZenCodingCodePretty :call zencoding#codePretty()
nnoremap <Plug>ZenCodingAnchorizeSummary :call zencoding#anchorizeURL(1)
nnoremap <Plug>ZenCodingAnchorizeURL :call zencoding#anchorizeURL(0)
nnoremap <Plug>ZenCodingRemoveTag :call zencoding#removeTag()
nnoremap <Plug>ZenCodingSplitJoinTagNormal :call zencoding#splitJoinTag()
vnoremap <Plug>ZenCodingMergeLines :call zencoding#mergeLines()
nnoremap <Plug>ZenCodingToggleComment :call zencoding#toggleComment()
nnoremap <Plug>ZenCodingImageSize :call zencoding#imageSize()
nnoremap <Plug>ZenCodingPrev :call zencoding#moveNextPrev(1)
nnoremap <Plug>ZenCodingNext :call zencoding#moveNextPrev(0)
vnoremap <Plug>ZenCodingBalanceTagOutwardVisual :call zencoding#balanceTag(-2)
nnoremap <Plug>ZenCodingBalanceTagOutwardNormal :call zencoding#balanceTag(-1)
vnoremap <Plug>ZenCodingBalanceTagInwardVisual :call zencoding#balanceTag(2)
nnoremap <Plug>ZenCodingBalanceTagInwardNormal :call zencoding#balanceTag(1)
nnoremap <Plug>ZenCodingExpandWord :call zencoding#expandAbbr(1,"")
nnoremap <Plug>ZenCodingExpandNormal :call zencoding#expandAbbr(3,"")
vnoremap <Plug>ZenCodingExpandVisual :call zencoding#expandAbbr(2,"")
nnoremap <silent> <Plug>SurroundRepeat .
vnoremap <silent> <F5>:call RangeUnCommentLine()
noremap <silent> <F5> :call UnCommentLine()
map <F3> :A
nnoremap <F2>:set invpaste paste           
nmap <F6> :TComment
imap S <Plug>ISurround
imap s <Plug>Isurround
inoremap <silent> 	 =TriggerSnippet()
imap  <Plug>SuperTabForward
imap  <Plug>SuperTabBackward
inoremap <silent> 	 =ShowAvailableSnips()
imap  <Plug>Isurround
imap A <Plug>ZenCodingAnchorizeSummary
imap a <Plug>ZenCodingAnchorizeURL
imap k <Plug>ZenCodingRemoveTag
imap j <Plug>ZenCodingSplitJoinTagInsert
imap / <Plug>ZenCodingToggleComment
imap i <Plug>ZenCodingImageSize
imap N <Plug>ZenCodingPrev
imap n <Plug>ZenCodingNext
imap D <Plug>ZenCodingBalanceTagOutwardInsert
imap d <Plug>ZenCodingBalanceTagInwardInsert
imap ; <Plug>ZenCodingExpandWord
imap , <Plug>ZenCodingExpandAbbr
inoremap s :TCommentAs =&ft_
inoremap n :TCommentAs =&ft 
inoremap a :TCommentAs 
inoremap b :TCommentBlock
inoremap <silent> r :TCommentRight
inoremap   :TComment 
inoremap <silent> p :norm! m`vip:TComment``
inoremap <silent>  :TComment
imap <silent> #.#.# =CommentBlock(input(""))
imap ,ihn :IHN
imap ,is :IHS:A
imap ,ih :IHS
let &cpo=s:cpo_save
unlet s:cpo_save
set autoindent
set backspace=indent,eol,start
set backupdir=~/.backup
set balloonexpr=eclim#util#Balloon(eclim#util#GetLineError(line('.')))
set comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
set commentstring=//%s
set directory=~/.backup
set expandtab
set fileencodings=ucs-bom,utf-8,default,latin1
set gdefault
set helplang=en
set hidden
set history=1000
set incsearch
set laststatus=2
set operatorfunc=tcomment#OperatorLine
set pastetoggle=<F2>
set ruler
set runtimepath=~/.vim,~/.vim/bundle/CSApprox,~/.vim/bundle/ScrollColor,~/.vim/bundle/TagHighlight,~/.vim/bundle/a,~/.vim/bundle/abolish,~/.vim/bundle/browser-reload,~/.vim/bundle/comments,~/.vim/bundle/fugitive,~/.vim/bundle/fuzzyfinder,~/.vim/bundle/gist,~/.vim/bundle/l9,~/.vim/bundle/lusty-explorer,~/.vim/bundle/markdown-preview,~/.vim/bundle/nerdtree,~/.vim/bundle/phpfolding,~/.vim/bundle/repeat,~/.vim/bundle/sco,~/.vim/bundle/snipMate,~/.vim/bundle/speeddating,~/.vim/bundle/surround,~/.vim/bundle/tabular,~/.vim/bundle/taglist,~/.vim/bundle/tmp,~/.vim/bundle/vim-comment-blocks.git,~/.vim/bundle/vim-markdown,~/.vim/bundle/vimux,~/.vim/bundle/visual-increment,~/.vim/bundle/zencoding,/usr/share/vim/vimfiles,/usr/share/vim/vim73,/usr/share/vim/vimfiles/after,~/.vim/bundle/snipMate/after,~/.vim/bundle/tabular/after,~/.vim/after,/usr/share/vim/vimfiles/ftplugin,/usr/share/vim/vimfiles/eclim,/usr/share/vim/vimfiles/eclim/after
set shiftwidth=4
set shortmess=atI
set showtabline=2
set softtabstop=4
set suffixes=.bak,~,.swp,.o,.info,.aux,.log,.dvi,.bbl,.blg,.brf,.cb,.ind,.idx,.ilg,.inx,.out,.toc,.class
set tabline=%!MyTabLine()
set wildmode=list:longest,full
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
cd ~/NetBeansProjects/2013-robot/src/edu/wpi/first/wpilibj/templates
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
badd +2 commands/AcquisitionForward.java
badd +0 commands/AcquisitionReverse.java
badd +0 commands/AcquisitionStop.java
badd +0 commands/CommandBase.java
badd +0 commands/ExampleCommand.java
badd +0 commands/ManualAcquisitionControl.java
badd +0 commands/ManualDriveTrainControl.java
badd +0 commands/toggleControls.java
badd +65 OI.java
badd +64 RobotMap.java
badd +25 subsystems/Acquisition.java
badd +0 subsystems/Camera.java
badd +7 subsystems/Chassis.java
badd +0 subsystems/ExampleSubsystem.java
badd +4 Team2945Robot.java
badd +39 subsystems/shooting.java
badd +19 commands/shootingOn.java
badd +18 commands/shootingOff.java
args commands/AcquisitionForward.java commands/AcquisitionReverse.java commands/AcquisitionStop.java commands/CommandBase.java commands/ExampleCommand.java commands/ManualAcquisitionControl.java commands/ManualDriveTrainControl.java commands/toggleControls.java OI.java RobotMap.java subsystems/Acquisition.java subsystems/Camera.java subsystems/Chassis.java subsystems/ExampleSubsystem.java Team2945Robot.java
edit OI.java
set splitbelow splitright
wincmd _ | wincmd |
vsplit
1wincmd h
wincmd w
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
exe 'vert 1resize ' . ((&columns * 79 + 79) / 158)
exe 'vert 2resize ' . ((&columns * 78 + 79) / 158)
argglobal
edit OI.java
nnoremap <buffer> <silent>  :JavaSearchContext
nnoremap <buffer> <silent> ,d :JavaDocSearch -x declarations
nnoremap <buffer> <silent> ,i :JavaImport
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
set colorcolumn=80
setlocal colorcolumn=80
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=eclim#java#complete#CodeComplete
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%-G%.%#[javac]\ %.%#:\ warning:\ unmappable\ character\ %.%#,%A%.%#[javac]\ %f:%l:\ %m,%C%.%#[javac]\ symbol\ %#:\ %m,%-Z%.%#[javac]\ %p^,%A%.%#[javadoc]\ %f:%l:\ %m,%-C%.%#[javadoc]\ location:\ %.%#,%-C%.%#[javadoc]\ %#,%-Z%.%#[javadoc]\ %p^,%-G%.%#[javadoc]\ Note:%.%#,%-G%.%#[javadoc]\ javadoc:%.%#,%.%#[javadoc]\ %f:\ %m,%.%#[java]\ org.apache.jasper.JasperException:\ file:%f(%l\\,%c)\ %m,%+A%.%#[junit]\ %.%#Failures:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[junit]\ Test\ %f\ FAILED,%+A%.%#[junit]\ %.%#Errors:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[junit]\ Test\ %f\ FAILED,%+A%.%#[cactus]\ %.%#Failures:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[cactus]\ Test\ %f\ FAILED,%+A%.%#[cactus]\ %.%#Errors:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[cactus]\ Test\ %f\ FAILED,%.%#[checkstyle]\ %f:%l:%c:\ %m,%.%#[checkstyle]\ %f:%l:\ %m,%+A%.%#eclim\ testng:\ %f:%m,%.%#\ ERROR\ %.%#\ line\ %l\ in\ file:\ %.%f%.:\ %m,%.%#[exec]\ %f:%l:%c:\ %m,%.%#[exec]\ %f:%l:\ %m,%f:%l:%c:\ %m,%-G%.%#
setlocal expandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
set nofoldenable
setlocal nofoldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
set foldmethod=indent
setlocal foldmethod=indent
setlocal foldminlines=1
set foldnestmax=10
setlocal foldnestmax=10
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=ql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=ant\ -find\ build.xml\ $*
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal nosmartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=8
setlocal tags=~/NetBeansProjects/2013-robot/.git/java.tags,~/NetBeansProjects/2013-robot/.git/tags,./tags,./TAGS,tags,TAGS
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 94 - ((69 * winheight(0) + 36) / 72)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
94
normal! 0
wincmd w
argglobal
edit Team2945Robot.java
nnoremap <buffer> <silent>  :JavaSearchContext
nnoremap <buffer> <silent> ,d :JavaDocSearch -x declarations
nnoremap <buffer> <silent> ,i :JavaImport
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
set colorcolumn=80
setlocal colorcolumn=80
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=eclim#java#complete#CodeComplete
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%-G%.%#[javac]\ %.%#:\ warning:\ unmappable\ character\ %.%#,%A%.%#[javac]\ %f:%l:\ %m,%C%.%#[javac]\ symbol\ %#:\ %m,%-Z%.%#[javac]\ %p^,%A%.%#[javadoc]\ %f:%l:\ %m,%-C%.%#[javadoc]\ location:\ %.%#,%-C%.%#[javadoc]\ %#,%-Z%.%#[javadoc]\ %p^,%-G%.%#[javadoc]\ Note:%.%#,%-G%.%#[javadoc]\ javadoc:%.%#,%.%#[javadoc]\ %f:\ %m,%.%#[java]\ org.apache.jasper.JasperException:\ file:%f(%l\\,%c)\ %m,%+A%.%#[junit]\ %.%#Failures:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[junit]\ Test\ %f\ FAILED,%+A%.%#[junit]\ %.%#Errors:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[junit]\ Test\ %f\ FAILED,%+A%.%#[cactus]\ %.%#Failures:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[cactus]\ Test\ %f\ FAILED,%+A%.%#[cactus]\ %.%#Errors:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[cactus]\ Test\ %f\ FAILED,%.%#[checkstyle]\ %f:%l:%c:\ %m,%.%#[checkstyle]\ %f:%l:\ %m,%+A%.%#eclim\ testng:\ %f:%m,%.%#\ ERROR\ %.%#\ line\ %l\ in\ file:\ %.%f%.:\ %m,%.%#[exec]\ %f:%l:%c:\ %m,%.%#[exec]\ %f:%l:\ %m,%f:%l:%c:\ %m,%-G%.%#
setlocal expandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
set nofoldenable
setlocal nofoldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
set foldmethod=indent
setlocal foldmethod=indent
setlocal foldminlines=1
set foldnestmax=10
setlocal foldnestmax=10
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=ql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=ant\ -find\ build.xml\ $*
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal nosmartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=8
setlocal tags=~/NetBeansProjects/2013-robot/.git/java.tags,~/NetBeansProjects/2013-robot/.git/tags,./tags,./TAGS,tags,TAGS
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 121 - ((43 * winheight(0) + 36) / 72)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
121
normal! 0
wincmd w
exe 'vert 1resize ' . ((&columns * 79 + 79) / 158)
exe 'vert 2resize ' . ((&columns * 78 + 79) / 158)
tabedit commands/CommandBase.java
set splitbelow splitright
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
argglobal
edit commands/CommandBase.java
nnoremap <buffer> <silent>  :JavaSearchContext
nnoremap <buffer> <silent> ,d :JavaDocSearch -x declarations
nnoremap <buffer> <silent> ,i :JavaImport
inoreabbr <buffer> logger logger=eclim#java#logging#LoggingInit("logger")
inoreabbr <buffer> log log=eclim#java#logging#LoggingInit("log")
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
set colorcolumn=80
setlocal colorcolumn=80
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=eclim#java#complete#CodeComplete
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=%-G%.%#[javac]\ %.%#:\ warning:\ unmappable\ character\ %.%#,%A%.%#[javac]\ %f:%l:\ %m,%C%.%#[javac]\ symbol\ %#:\ %m,%-Z%.%#[javac]\ %p^,%A%.%#[javadoc]\ %f:%l:\ %m,%-C%.%#[javadoc]\ location:\ %.%#,%-C%.%#[javadoc]\ %#,%-Z%.%#[javadoc]\ %p^,%-G%.%#[javadoc]\ Note:%.%#,%-G%.%#[javadoc]\ javadoc:%.%#,%.%#[javadoc]\ %f:\ %m,%.%#[java]\ org.apache.jasper.JasperException:\ file:%f(%l\\,%c)\ %m,%+A%.%#[junit]\ %.%#Failures:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[junit]\ Test\ %f\ FAILED,%+A%.%#[junit]\ %.%#Errors:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[junit]\ Test\ %f\ FAILED,%+A%.%#[cactus]\ %.%#Failures:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[cactus]\ Test\ %f\ FAILED,%+A%.%#[cactus]\ %.%#Errors:\ %[%^0]%.%#\ Time\ elapsed:\ %.%#,%-Z%.%#[cactus]\ Test\ %f\ FAILED,%.%#[checkstyle]\ %f:%l:%c:\ %m,%.%#[checkstyle]\ %f:%l:\ %m,%+A%.%#eclim\ testng:\ %f:%m,%.%#\ ERROR\ %.%#\ line\ %l\ in\ file:\ %.%f%.:\ %m,%.%#[exec]\ %f:%l:%c:\ %m,%.%#[exec]\ %f:%l:\ %m,%f:%l:%c:\ %m,%-G%.%#
setlocal expandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
set nofoldenable
setlocal nofoldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
set foldmethod=indent
setlocal foldmethod=indent
setlocal foldminlines=1
set foldnestmax=10
setlocal foldnestmax=10
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=ql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=^s*import
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
setlocal nolinebreak
setlocal nolisp
setlocal nolist
setlocal makeprg=ant\ -find\ build.xml\ $*
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal nosmartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=
setlocal suffixesadd=.java
setlocal swapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=8
setlocal tags=~/NetBeansProjects/2013-robot/.git/java.tags,~/NetBeansProjects/2013-robot/.git/tags,./tags,./TAGS,tags,TAGS
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 22 - ((21 * winheight(0) + 36) / 72)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
22
normal! 056l
tabnext 1
if exists('s:wipebuf')
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 shortmess=atI
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
