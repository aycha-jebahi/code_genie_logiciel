<?php
class PartenaireController extends Controller
{
    protected $partenaireService;

    public function __construct(PartenaireServiceInterface $partenaireService)
    {
        $this->middleware('auth:partenaire');
        $this->partenaireService = $partenaireService;
    }

    public function index()
    {
        $partenaires = $this->partenaireService->getAllPartenaires();
        return view('partenaire.index', compact('partenaires'));
    }

}
