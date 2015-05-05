#! perl
# usage: 
#   open terminal
#   navigate to the TeachingKidsProgramming.Source.Java repository on your computer
#   enter the command all on one line
#      cat <path to java file> | perl tablemaker.pl > table.md
#
# example -- simple square:
#    cat src/main/java/org/teachingkidsprogramming/section01forloops/SimpleSquare.java | perl tablemaker.pl > table.md

my @lines = map {s/\A\s*//; $_} grep { /\/{2}/ } <>;
print '| Image | Code/Text | Concepts |' . "\n";
print '|------|----------|---------|' . "\n";
for (@lines){
	chomp;
	print "| ![link to image](<Website URL>) | $_ | concept |\n";
}
