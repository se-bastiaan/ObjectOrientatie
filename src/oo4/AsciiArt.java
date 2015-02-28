package oo4;

public class AsciiArt implements TekenLoipe {

    private Loipe loipe;
    private StringBuffer stringBuffer;

    public AsciiArt(Loipe loipe) {
        this.loipe = loipe;
    }

    @Override
    public void teken() {
        int height = this.loipe.getHeight();
        int width = this.loipe.getWidth();
        stringBuffer = new StringBuffer();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Fragment fragment = this.loipe.getFragment(x, y);

                if(fragment == null) {
                    stringBuffer.append(" ");
                } else {
                    switch (fragment) {
                        case NZ:
                            stringBuffer.append('║');
                            break;
                        case ZO:
                            stringBuffer.append('╔');
                            break;
                        case NO:
                            stringBuffer.append('╚');
                            break;
                        case ZW:
                            stringBuffer.append('╗');
                            break;
                        case OW:
                            stringBuffer.append('═');
                            break;
                        case NW:
                            stringBuffer.append('╝');
                            break;
                        case KR:
                            stringBuffer.append('╬');
                            break;
                        case SKI:
                            stringBuffer.append('*');
                            break;
                        /*
                        For stupid computers:
                        case NZ:
                            stringBuffer.append('|');
                            break;
                        case ZO:
                            stringBuffer.append(',');
                            break;
                        case NO:
                            stringBuffer.append('‘');
                            break;
                        case ZW:
                            stringBuffer.append('.');
                            break;
                        case OW:
                            stringBuffer.append('-');
                            break;
                        case NW:
                            stringBuffer.append('’');
                            break;
                        case KR:
                            stringBuffer.append('+');
                            break;
                        case SKI:
                            stringBuffer.append('*');
                            break;
                         */
                    }
                }
            }
            stringBuffer.append('\n');
        }
        System.out.print(stringBuffer.toString());
    }

    @Override
    public void setPosition(Punt p) {
        Fragment curFrag = loipe.getFragment(p.getX(), p.getY());
        loipe.setFragment(p.getX(), p.getY(), Fragment.SKI);
        teken();
        loipe.setFragment(p.getX(), p.getY(), curFrag);
    }

}
